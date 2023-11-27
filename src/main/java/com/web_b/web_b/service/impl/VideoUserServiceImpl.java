package com.web_b.web_b.service.impl;

import com.web_b.web_b.mapper.VideoUserMapper;
import com.web_b.web_b.pojo.VideoUser;
import com.web_b.web_b.service.VideoUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class VideoUserServiceImpl implements VideoUserService {

    @Autowired // 注入mapper
    private VideoUserMapper videoUserMapper;

    @Override
    public void addComment(VideoUser videoUser) {
        // videoUser.setUpdateTime(LocalDateTime.now());
        // 调用mapper，添加评论
        videoUserMapper.addComment(videoUser);
    }

    @Override
    public List<VideoUser> findCommentByVideoPath(String filePath) {
        // 调用mapper，查询评论
        return videoUserMapper.findCommentByVideoPath(filePath);
    }

    @Override
    public void deleteCommentByVideoPathAndUserId(String filePath, Integer userId, LocalDateTime updateTime) {
        // 调用mapper，删除评论
        videoUserMapper.deleteCommentByVideoPathAndUserId(filePath, userId, updateTime);
    }
}
