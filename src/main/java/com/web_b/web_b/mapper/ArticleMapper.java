package com.web_b.web_b.mapper;


import com.web_b.web_b.pojo.Article;
import org.apache.ibatis.annotations.*;

@Mapper
public interface ArticleMapper {

    @Select("select * from article")
    Article[] findAllArticle();

    @Insert("insert into article (title, content, update_time) values (#{title}, #{content}, #{updateTime})")
    void addArticle(Article article);

    @Delete("delete from article where id = #{id}")
    void deleteArticle(Article article);

    @Update("update article set content = #{content}, update_time = #{updateTime} where id = #{id}")
    void updateArticle(Article article);
}
