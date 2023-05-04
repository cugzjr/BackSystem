package com.xxxx.server.controller;

import com.xxxx.server.param.UserInfoParam;
import com.xxxx.server.pojo.RespBean;
import com.xxxx.server.service.IUserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zjr
 * @since 2023-05-03
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService userService;
    @ApiOperation(value = "查看所有用户信息")
    @GetMapping("/ten-users")
    public List<UserInfoParam> getAllUsers(@RequestParam(value = "page") Integer page){
        return userService.getAllUsers(page);
    }
    @ApiOperation(value = "查看所有用户信息数量")
    @GetMapping("/num")
    public Integer getNumUsers(){
        return userService.getNumUsers();
    }
    @ApiOperation(value = "修改用户状态")
    @DeleteMapping("/{userId}")
    public RespBean updateState(@PathVariable Integer userId){
        return userService.updateState(userId);
    }

    @ApiOperation(value = "根据id查询用户")
    @GetMapping("/getUserById")
    public UserInfoParam getNumUsers(@RequestParam(value = "userId") Integer userId){
        return userService.getUser(userId);
    }
}
