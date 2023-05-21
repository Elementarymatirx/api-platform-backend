package com.zsw.api.service.impl.inner;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zsw.api.mapper.UserMapper;
import com.zsw.api.service.UserService;
import com.zsw.common.common.ErrorCode;
import com.zsw.common.exception.BusinessException;
import com.zsw.common.model.entity.User;
import com.zsw.common.model.vo.UserVO;
import com.zsw.common.service.InnerUserService;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.DubboService;

import javax.annotation.Resource;

@DubboService
public class InnerUserServiceImpl implements InnerUserService {

    @Resource
    UserMapper userMapper;
    @Resource
    UserService userService;

    @Override
    public User getInvokeUser(String ak) {
        if (StringUtils.isAnyBlank(ak)) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("accessKey", ak);
        User user = userMapper.selectOne(queryWrapper);

        return user;
    }

    @Override
    public UserVO getLoginUser(String cookie) {
        return userService.getLoginUser(cookie);
    }
}
