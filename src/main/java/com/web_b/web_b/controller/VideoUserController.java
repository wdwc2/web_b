package com.web_b.web_b.controller;

import com.web_b.web_b.pojo.Result;
import com.web_b.web_b.pojo.VideoUser;
import com.web_b.web_b.service.VideoUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api")
public class VideoUserController {
    @Autowired
    private VideoUserService videoUserService;

    // 根据视频路径查询评论
    @RequestMapping("/findCommentByVideoPath")
    public Result findCommentByVideoPath(String filePath){
        // 调用service，查询评论
        List<VideoUser> videoUsers = videoUserService.findCommentByVideoPath(filePath);
        return new Result(200,"ok", videoUsers);
    }

    // 添加评论
    @RequestMapping("/addComment")
    public Result addComment(@RequestBody VideoUser videoUser){
        System.out.println(videoUser);
        // 调用service，添加评论
        videoUserService.addComment(videoUser);
        return new Result(200,"ok", null);
    }

    // 根据视频路径和用户id删除评论
    @RequestMapping("/deleteCommentByVideoPathAndUserId")
    public Result deleteCommentByVideoPathAndUserId(@RequestBody VideoUser videoUser){
        // 调用service，删除评论
        String filePath = videoUser.getFilePath();
        Integer userId = videoUser.getUserId();
        LocalDateTime updateTime = videoUser.getUpdateTime();
        videoUserService.deleteCommentByVideoPathAndUserId( filePath, userId, updateTime);
        return new Result(200,"ok", null);
    }

    // 获取别人对自己每个发布视频的评论

}
