package com.xxxx.server.controller;

import com.xxxx.server.param.LoginParam;
import com.xxxx.server.pojo.RespBean;
import com.xxxx.server.service.LoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zjr
 * @since 2023-05-03
 */
@Api(tags = "LoginController")
@RestController
public class LoginController {
    @Autowired
    private LoginService loginService;

    /**
     * 登录接口
     * @param loginParam
     * @param request
     * @returnusername
     */
    @ApiOperation(value = "管理员登录")
    @PostMapping("/login")
    public RespBean login(@RequestBody LoginParam loginParam, HttpServletRequest request){
        return loginService.login(loginParam,request);
    }
}
