package com.web_b.web_b.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.web_b.web_b.mapper.ArticleMapper;
import com.web_b.web_b.pojo.Article;
import com.web_b.web_b.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ArticleServiceImpl
        extends ServiceImpl<ArticleMapper, Article>
        implements ArticleService {

    @Autowired // 注入mapper
    private ArticleMapper articleMapper;


    @Override
    public void addArticle(Article article) {
        // 设置更新时间
        article.setUpdateTime(LocalDateTime.now());
        articleMapper.addArticle(article);
    }

    @Override
    public void updateArticle(Article article) {
        // 设置更新时间
        article.setUpdateTime(LocalDateTime.now());
        System.out.println(article);
        articleMapper.updateArticle(article);
    }
}
