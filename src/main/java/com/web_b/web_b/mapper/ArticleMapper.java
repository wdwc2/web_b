package com.web_b.web_b.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.web_b.web_b.pojo.Article;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ArticleMapper
        extends BaseMapper<Article> {

    @Insert("insert into article (title, content, update_time) values (#{title}, #{content}, #{updateTime})")
    void addArticle(Article article);

    void updateArticle(Article article);
}
