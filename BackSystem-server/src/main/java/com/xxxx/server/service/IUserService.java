package com.xxxx.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xxxx.server.param.UserInfoParam;
import com.xxxx.server.pojo.RespBean;
import com.xxxx.server.pojo.User;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zjr
 * @since 2023-05-03
 */
public interface IUserService extends IService<User> {
    List<UserInfoParam> getAllUsers(Integer page);
    RespBean updateState(Integer userId);
    Integer getNumUsers();
    UserInfoParam getUser(Integer userId);
}
