package com.web_b.web_b.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.web_b.web_b.mapper.UserMapper;
import com.web_b.web_b.pojo.User;
import com.web_b.web_b.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
        implements UserService {

    @Autowired // 注入mapper
    private UserMapper userMapper;
    @Override
    // 根据用户名和密码查询用户
    public User findUserByNameAndPwd(User user) {
        return userMapper.findUserByNameAndPwd(user);
    }
    // 查询全部普通用户
    @Override
    public User[] findAllUser() {
        return userMapper.findAllUser();
    }
    // 添加用户
    @Override
    public void addUser(User user) {
        userMapper.addUser(user);
    }


    @Override
    public User findUserByName(User user) {
        return userMapper.findUserByName(user);
    }

    @Override
    public User updateUser(User user) {
        userMapper.updateUser(user);
        return userMapper.findUserByName(user);
    }
}
