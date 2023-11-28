package com.web_b.web_b.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.web_b.web_b.pojo.VideoUser;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public interface VideoUserService extends IService<VideoUser> {

    void addComment(VideoUser videoUser);

    List<VideoUser> findCommentByVideoPath(String filePath);

    void deleteCommentByVideoPathAndUserId(String filePath, Integer userId, LocalDateTime updateTime);
}
