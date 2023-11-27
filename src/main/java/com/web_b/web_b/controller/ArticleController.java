package com.web_b.web_b.controller;

import com.web_b.web_b.pojo.Article;
import com.web_b.web_b.pojo.Result;
import com.web_b.web_b.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")

public class ArticleController {

    @Autowired
    private ArticleService articleService;

    // 查询全部公告
    @RequestMapping("/getAllArticle")
    public Result getAllArticle(){
        // 调用service，查询全部公告
        Article[] articles = articleService.findAllArticle();
        return new Result(200,"ok", articles);
    }

    // 添加公告
    @RequestMapping("/addArticle")
    public Result addArticle(@RequestBody Article article){
        // 调用service，添加公告
        articleService.addArticle(article);
        return new Result(200,"ok", null);
    }

    // 删除公告
    @RequestMapping("/deleteArticle")
    public Result deleteArticle(Article article){
        // 调用service，删除公告
        articleService.deleteArticle(article);
        return new Result(200,"ok", null);
    }

    // 修改公告
    @RequestMapping("/updateArticle")
    public Result updateArticle(@RequestBody Article article){
        // 调用service，修改公告
        articleService.updateArticle(article);
        return new Result(200,"ok", null);
    }
}
