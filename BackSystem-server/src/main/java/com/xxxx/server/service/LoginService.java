package com.xxxx.server.service;

import com.xxxx.server.param.LoginParam;
import com.xxxx.server.pojo.RespBean;

import javax.servlet.http.HttpServletRequest;

public interface LoginService {
    /**
     * 登录
     * @param loginParam
     * @param request
     * @return
     */
    RespBean login(LoginParam loginParam, HttpServletRequest request);
}
