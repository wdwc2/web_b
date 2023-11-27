package com.web_b.web_b.service;

import com.web_b.web_b.pojo.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    // 根据用户名和密码查询用户
    User findUserByNameAndPwd(User user);

    // 查询全部普通用户
    User[] findAllUser();

    // 添加用户
    void addUser(User user);

    void deleteUser(String id);

    User findUserByName(User user);

    User updateUser(User user);
}
