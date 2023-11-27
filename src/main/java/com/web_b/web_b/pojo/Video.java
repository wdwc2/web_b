package com.web_b.web_b.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Video {
    private String filePath;// 文件路径,主键
    private String name;// 视频名
    private String type;// 视频类型
    private String difficulty;// 难度
    private String description;// 描述
    private LocalDateTime uploadTime;// 上传时间
    private String privateOrPublic;// 公开或私有
    private String userName;// 作者名
    private String auditing;// 审核状态
    private String violationReason;// 违规原因
}
