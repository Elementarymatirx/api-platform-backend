package com.zsw.common.service;


import com.zsw.common.model.entity.User;
import com.zsw.common.model.vo.UserVO;

public interface InnerUserService  {

    /**
     * 通过ak获取调用的用户
     * @param ak
     * @return
     */
    User getInvokeUser(String ak);

    /**
     * 获取登录的用户
     * @param cookie
     * @return
     */
    UserVO getLoginUser(String cookie);

}
