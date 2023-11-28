package com.web_b.web_b.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("article")
public class Article {
    private Integer id;
    private String title;
    private String content;
    private LocalDateTime updateTime;
}
