package com.zsw.gateway.config;

import com.zsw.gateway.filter.InterfaceFilter;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

/**
 * 网关配置
 */
@Configuration
public class GatewayConfig {

    @Resource
    InterfaceFilter interfaceFilter;

    /**
     * 控制对接口的路由请求
     * @param builder
     * @return
     */
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("interface",r -> r.path("/interface/**")
                        .filters(f -> f.filter(interfaceFilter))
                        .uri("lb://api-interface"))
                .build();
    }
}
