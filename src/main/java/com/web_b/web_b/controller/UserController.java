package com.web_b.web_b.controller;

import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.web_b.web_b.pojo.Result;
import com.web_b.web_b.pojo.User;
import com.web_b.web_b.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api")

public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/user")
    // 登录
    public Result login(@RequestBody User user){
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

    @GetMapping("/getAllUser")
    // 查询全部普通用户
    public Result getAllUser(){
        // 调用service，查询全部普通用户
        List<User> users = userService.findAllUser();
        return new Result(200,"ok", users);
    }
    // 添加用户
    @PostMapping("/addUser")
    public Result addUser(@RequestBody User user){
        // 判断用户名是否已存在
        User user1 = userService.findUserByName(user);
        if (user1 != null){
            return new Result(400,"用户名已存在", null);
        }// 调用service，添加用户
        else {
            // 返回新添加用户的信息
            User user2 = userService.addUser(user);
            return new Result(200,"ok", user2);
        }
    }
    // 删除用户
    @GetMapping("/deleteUser")
    public Result deleteUser(String id){
        // 调用service，删除用户
        userService.removeById(id);
        return new Result(200,"ok", null);
    }
    // 修改用户
    @PostMapping("/updateUser")
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
    @PostMapping("/statusUser")
    public Result freezeUser(@RequestBody User user){
        // 调用service，修改用户
        user = userService.updateUser(user);
        return new Result(200,"ok", user);
    }

    // 分页查询用户
    @GetMapping("/pageUser")
    public Result pageUser(Integer currentPage, Integer pageSize){

        Page<User> page = new Page<>(currentPage, pageSize);//参数一是当前页，参数二是每页个数
        page.addOrder(OrderItem.desc("id"));
        // 调用service，分页查询用户
        userService.page(page);
        return new Result(200,"ok", page);
    }
}
