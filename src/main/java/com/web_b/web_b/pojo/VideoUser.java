package com.web_b.web_b.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VideoUser {
    private Integer userId;
    private String filePath;
    private Integer score;
    private String comment;
    private LocalDateTime updateTime;
    private String userName;
}
