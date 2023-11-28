package com.web_b.web_b.controller;

import com.web_b.web_b.pojo.Result;
import com.web_b.web_b.pojo.User;
import com.web_b.web_b.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@RequestMapping("/api")

public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/user")
    // 根据用户名和密码查询用户
    public Result User(@RequestBody User user){
        //System.out.println(user);
        // 调用service，查询是否有该用户
        user = userService.findUserByNameAndPwd(user);
        if (user == null){
            return new Result(400,"用户名或密码错误", null);
        }
        else {
            return new Result(200,"ok", user);
        }
    }

    @RequestMapping("/getAllUser")
    // 查询全部普通用户
    public Result getAllUser(){
        // 调用service，查询全部普通用户
        User[] users = userService.findAllUser();
        return new Result(200,"ok", users);
    }
    // 添加用户
    @RequestMapping("/addUser")
    public Result addUser(@RequestBody User user){
        // 判断用户名是否已存在
        User user1 = userService.findUserByName(user);
        if (user1 != null){
            return new Result(400,"用户名已存在", null);
        }// 调用service，添加用户
        else {
            userService.addUser(user);
            // 返回新添加用户的信息
            user = userService.findUserByNameAndPwd(user);
            return new Result(200,"ok", user);
        }
    }
    // 删除用户
    @RequestMapping("/deleteUser")
    public Result deleteUser(String id){
        // 调用service，删除用户
        userService.removeById(id);
        return new Result(200,"ok", null);
    }
    // 修改用户
    @RequestMapping("/updateUser")
    public Result updateUser(@RequestBody User user){
        // 先查询用户名是否已存在，并且不是当前用户
        User user1 = userService.findUserByName(user);
        if (user1 != null && !Objects.equals(user1.getId(), user.getId())){
            return new Result(400,"用户名已存在", null);
        }
        // 调用service，修改用户
        user = userService.updateUser(user);
        return new Result(200,"ok", user);
    }

    // 改变用户状态
    @RequestMapping("/statusUser")
    public Result freezeUser(@RequestBody User user){
        // 调用service，修改用户
        user = userService.updateUser(user);
        return new Result(200,"ok", user);
    }

}
