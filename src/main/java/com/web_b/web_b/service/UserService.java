package com.web_b.web_b.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.web_b.web_b.pojo.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService extends IService<User> {

    // 根据用户名和密码查询用户
    User findUserByNameAndPwd(User user);

    // 查询全部普通用户
    List<User> findAllUser();

    // 添加用户
    User addUser(User user);

    User findUserByName(User user);

    User updateUser(User user);
}
