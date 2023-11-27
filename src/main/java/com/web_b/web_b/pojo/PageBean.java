package com.web_b.web_b.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
// 分页结果类
public class PageBean {
    private long total;// 总记录数
    private List rows;// 当前页结果
}
