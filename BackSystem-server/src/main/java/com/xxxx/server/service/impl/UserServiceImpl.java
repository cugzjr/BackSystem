package com.xxxx.server.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xxxx.server.mapper.UserInfoMapper;
import com.xxxx.server.mapper.UserMapper;
import com.xxxx.server.param.UserInfoParam;
import com.xxxx.server.pojo.RespBean;
import com.xxxx.server.pojo.User;
import com.xxxx.server.pojo.UserInfo;
import com.xxxx.server.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zjr
 * @since 2023-05-03
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserInfoMapper userInfoMapper;

    /**
     * 获取所有用户信息
     * @param page
     * @return
     */
    @Override
    public List<UserInfoParam> getAllUsers(Integer page){
        List<UserInfoParam> userInfoParamList = new ArrayList<>();
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.isNotNull("id");
        List<User> userList = userMapper.selectList(userQueryWrapper);
        List<User> userPage = new ArrayList<>();
        // 一页商品的数量
        int size = 8;
        int i= page * 8;
        while(size>0)
        {
            try {
                userPage.add(userList.get(i));
            } catch (Exception e) {
                break;
            }
            i ++;
            -- size;
        }
        for(User user:userPage){
            UserInfo userInfo = userInfoMapper.selectOne(new QueryWrapper<UserInfo>().eq("user_id",user.getId()));
            if(userInfo != null)
            {
                UserInfoParam userInfoParam = new UserInfoParam();
                userInfoParam.setUserId(user.getId());
                if(userInfo.getUsername() == null){
                    userInfoParam.setUserName(null);
                }
                else{
                    userInfoParam.setUserName(userInfo.getUsername());
                }
                userInfoParam.setUserAge(userInfo.getAge());
                if(userInfo.getGender() == null){
                    userInfoParam.setUserGender(null);
                }
                else if(userInfo.getGender() == 1){
                    userInfoParam.setUserGender("男");
                }
                else{
                    userInfoParam.setUserGender("女");
                }
                userInfoParam.setUserSignature(userInfo.getSignature());
                if(user.getState()){
                    userInfoParam.setUserState("正常");
                }
                else{
                    userInfoParam.setUserState("封号");
                }
                userInfoParamList.add(userInfoParam);
            }
        }
        return userInfoParamList;
    }
    @Override
    public Integer getNumUsers(){
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.isNotNull("id");
        List<User> userList = userMapper.selectList(userQueryWrapper);
        return userList.size();
    }
    @Override
    public RespBean updateState(Integer userId){
        User user = userMapper.selectOne(new QueryWrapper<User>().eq("id", userId));
        user.setState(!user.getState());
        userMapper.updateById(user);
        return RespBean.success("修改成功");
    }
    @Override
    public UserInfoParam getUser(Integer userId){
        UserInfo userInfo = userInfoMapper.selectOne(new QueryWrapper<UserInfo>().eq("user_id",userId));
        User user = userMapper.selectOne(new QueryWrapper<User>().eq("id",userId));
        UserInfoParam userInfoParam = new UserInfoParam();
        userInfoParam.setUserId(user.getId());
        if(userInfo.getUsername() == null){
            userInfoParam.setUserName(null);
        }
        else{
            userInfoParam.setUserName(userInfo.getUsername());
        }
        userInfoParam.setUserAge(userInfo.getAge());
        if(userInfo.getGender() == null){
            userInfoParam.setUserGender(null);
        }
        else if(userInfo.getGender() == 1){
            userInfoParam.setUserGender("男");
        }
        else{
            userInfoParam.setUserGender("女");
        }
        userInfoParam.setUserSignature(userInfo.getSignature());
        if(user.getState()){
            userInfoParam.setUserState("正常");
        }
        else{
            userInfoParam.setUserState("封号");
        }
        return userInfoParam;
    }
}
