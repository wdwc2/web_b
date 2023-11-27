package com.web_b.web_b.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Integer id;
    private String userName;
    private String passWord;
    private String userType;
    private Integer score;
    private LocalDateTime createTime;
    private String status;

    public Map<String, Object> toMap() {
        return Map.of("id", id, "userName", userName, "passWord", passWord, "userType", userType, "score", score, "createTime", createTime, "status", status);
    }
}
