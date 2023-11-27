package com.web_b.web_b.mapper;

import com.web_b.web_b.pojo.VideoUser;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface VideoUserMapper {

    // 添加评论
    @Insert("insert into video_user (user_id,file_path,score,comment,update_time) values (#{userId}, #{filePath}, #{score}, #{comment}, #{updateTime})")
    void addComment(VideoUser videoUser);

    // 根据视频路径查询评论,并按时间排序,联合user表查询用户名
    @Select("select * from video_user vu left join user u on vu.user_id = u.id where file_path = #{filePath} order by update_time desc")
    List<VideoUser> findCommentByVideoPath(String filePath);

    // 根据视频路径和用户id时间删除评论
    @Delete("delete from video_user where file_path = #{filePath} and user_id = #{userId} and update_time = #{updateTime}")
    void deleteCommentByVideoPathAndUserId(String filePath, Integer userId, LocalDateTime updateTime);
}
