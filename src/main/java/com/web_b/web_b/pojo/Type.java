package com.web_b.web_b.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Type {
    private String type;
    private String description;
    private LocalDateTime updateTime;
}
