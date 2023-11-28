package com.web_b.web_b.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.web_b.web_b.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper // 这是一个操作数据库的mapper
public interface UserMapper
        extends BaseMapper<User> {
    // 根据用户名和密码查询用户
    @Select("select * from user where userName=#{userName} and passWord=#{passWord}")
    User findUserByNameAndPwd(User user);

    // 查询全部普通用户,按积分降序排列
    @Select("select * from user where user_type='普通用户' order by score desc")
    User[] findAllUser();

    // 添加用户
    @Select("insert into user (userName, passWord, user_type,create_time) values (#{userName}, #{passWord}, #{userType}, #{createTime})")
    void addUser(User user);

    // 根据用户名查询用户
    @Select("select * from user where userName=#{userName}")
    User findUserByName(User user);

    // 根据条件动态修改用户信息
    void updateUser(User user);
}
