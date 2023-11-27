package com.web_b.web_b.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
// 通用的返回类
public class Result {
    private Integer code;// 表示状态码
    private String message;// 表示消息
    private Object data;// 表示数据
}
