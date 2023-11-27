package com.web_b.web_b.service;

import com.web_b.web_b.pojo.Article;
import org.springframework.stereotype.Service;

@Service
public interface ArticleService {
    Article[] findAllArticle();

    void addArticle(Article article);

    void deleteArticle(Article article);

    void updateArticle(Article article);
}
