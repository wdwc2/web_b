package com.web_b.web_b.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("video_user")
public class VideoUser {
    private Integer userId;
    private String filePath;
    private Integer score;
    private String comment;
    private LocalDateTime updateTime;
    private String userName;
}
