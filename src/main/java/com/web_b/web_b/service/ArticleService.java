package com.web_b.web_b.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.web_b.web_b.pojo.Article;
import org.springframework.stereotype.Service;

@Service
public interface ArticleService extends IService<Article> {

    void addArticle(Article article);

    void updateArticle(Article article);
}
