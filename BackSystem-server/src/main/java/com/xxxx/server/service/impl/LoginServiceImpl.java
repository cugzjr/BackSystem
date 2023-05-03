package com.xxxx.server.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.xxxx.server.mapper.ManagerMapper;
import com.xxxx.server.param.LoginParam;
import com.xxxx.server.pojo.Manager;
import com.xxxx.server.pojo.RespBean;
import com.xxxx.server.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private ManagerMapper managerMapper;

    /**
     * 管理员登录
     * @param loginParam
     * @param request
     * @return
     */
    @Override
    public RespBean login(LoginParam loginParam, HttpServletRequest request){
        String username = loginParam.getUsername();
        String password = loginParam.getPassword();
        String code = loginParam.getCode();
        String captcha = (String) request.getSession().getAttribute("captcha");
        if(StringUtils.isEmpty(code)||!captcha.equalsIgnoreCase(code)){
            return RespBean.error("验证码输入错误，请重新输入");
        }
        Manager manager = managerMapper.selectOne(new QueryWrapper<Manager>().eq("username",username));
        if(manager == null) {
            return RespBean.error("用户名不存在");
        }
        if(!password.equals(manager.getPassword())){
            return RespBean.error("密码错误");
        }
        return RespBean.success("登录成功");
    }
}
