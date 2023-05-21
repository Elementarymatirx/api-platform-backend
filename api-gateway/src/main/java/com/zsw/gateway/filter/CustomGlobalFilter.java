package com.zsw.gateway.filter;

import cn.hutool.core.text.AntPathMatcher;
import com.zsw.common.common.ErrorCode;
import com.zsw.common.exception.BusinessException;
import com.zsw.common.model.vo.UserVO;
import com.zsw.common.service.InnerUserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpCookie;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static com.zsw.common.constant.CookieConstant.COOKIE_KEY;

/**
 * 全局请求过滤器
 */
@Component
@Slf4j
public class CustomGlobalFilter implements GlobalFilter, Ordered {
    public static final List<String> NOT_LOGIN_PATH = Arrays.asList(
            "/api/user/login", "/api/user/loginBySms", "/api/user/register", "/api/user/smsCaptcha",
            "/api/user/getCaptcha", "/interface/**","/api/third/alipay/**","/api/interfaceInfo/sdk"
    );

    @DubboReference
    InnerUserService innerUserService;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        ServerHttpResponse response = exchange.getResponse();
        String path = request.getPath().value();
        // 判断该接口是否需要登录
        List<Boolean> collect = NOT_LOGIN_PATH.stream().map(notLoginPath -> {
            AntPathMatcher antPathMatcher = new AntPathMatcher();
            return antPathMatcher.match(notLoginPath, path);
        }).collect(Collectors.toList());
        if (collect.contains(true)) {
            return chain.filter(exchange);
        }

        MultiValueMap<String, HttpCookie> cookies = request.getCookies();
        HttpCookie httpCookie = cookies.getFirst("cookie");
        if (httpCookie == null) {
            return handleNoAuth(response);
        }
        String cookie = httpCookie.toString();
        String[] split = cookie.split("=");

        if (!COOKIE_KEY.equals(split[0]) || StringUtils.isEmpty(cookie)) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        cookie = split[1];
        UserVO loginUser = innerUserService.getLoginUser(cookie);
        if (loginUser == null) {
            return handleNoAuth(response);
        }
        //请求转发，响应日志
        return chain.filter(exchange);
    }

    public Mono<Void> handleNoAuth(ServerHttpResponse response) {
        response.setStatusCode(HttpStatus.FORBIDDEN);
        return response.setComplete();
    }

    @Override
    public int getOrder() {
        return -1;
    }
}