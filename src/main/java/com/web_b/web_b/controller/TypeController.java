package com.web_b.web_b.controller;

import com.web_b.web_b.pojo.Result;
import com.web_b.web_b.pojo.Type;
import com.web_b.web_b.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")

public class TypeController {
    @Autowired
    private TypeService typeService;

    // 查询全部类型
    @RequestMapping("/findAllType")
    public Result allType(){
        // 调用service，查询全部类型
        List<Type> types = typeService.findAllType();
        return new Result(200,"ok", types);
    }

    // 根据type查询类型
    @RequestMapping("/findType")
    public Result findType(Type type){
        // 调用service，查询类型
        type = typeService.findType(type);
        return new Result(200,"ok", type);
    }

    // 添加类型
    @RequestMapping("/addType")
    public Result addType(@RequestBody Type type){
        // 调用service，添加类型
        typeService.addType(type);
        return new Result(200,"ok", null);
    }

    // 删除类型
    @RequestMapping("/deleteType")
    public Result deleteType(Type type){
        // 调用service，删除类型
        typeService.deleteType(type);
        return new Result(200,"ok", null);
    }

    // 修改类型
    @RequestMapping("/updateType")
    public Result updateType(@RequestBody Type type){
        // 调用service，修改类型
        type = typeService.updateType(type);
        System.out.println(type);
        return new Result(200,"ok", type);
    }
}
