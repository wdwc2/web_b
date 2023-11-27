package com.web_b.web_b.mapper;

import com.web_b.web_b.pojo.PageBean;
import com.web_b.web_b.pojo.Video;
import org.apache.ibatis.annotations.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@Mapper // 这是一个操作数据库的mapper
public interface VideoMapper {

    // 插入视频
    @Insert("insert into video (name, type, difficulty, description, upload_time, private_or_public, file_path, username) values (#{name}, #{type}, #{difficulty}, #{description}, #{uploadTime}, #{privateOrPublic}, #{filePath}, #{userName})")
    void uploadVideo(Video video);

    // 根据上传者查询视频
    @Select("select * from video where username=#{userName}")
    Video[] findVideoByUserName(String userName);

    // 根据视频名编辑视频
    void editVideoByName(Video video);

    // 根据视频名删除视频
    @Delete("delete from video where file_path=#{filePath}")
    void deleteVideoByName(String filePath);

    // 查询所有用户上传的视频
    @Select("select * from video")
    List<Video> findAllVideo();

    // 分页查询所有用户上传的视频
    @Select("select * from video limit #{start}, #{end}")
    List<Video> findAllVideoByPage(Integer start, Integer end);

    // 查询所有用户上传的视频的数量
    @Select("select count(*) from video")
    Long findAllVideoCount();

    // 根据视频名批量删除视频
    void deleteVideoByNames(List<String> filePaths);

    @Select("select * from video where file_path=#{filePath}")
    Video findVideoByPath(String filePath);

    // 审核视频
    @Update("update video set auditing=#{auditing}, violation_reason=#{violationReason} where file_path=#{filePath}")
    void checkVideo(String filePath, String auditing, String violationReason);


    // 查询所有公开视频,并按照上传时间降序排列,并且审核通过,模糊查询
    @Select("select * from video where auditing='合格' and private_or_public='public' and (name like concat('%',#{keyWord},'%') or type like concat('%',#{keyWord},'%') or difficulty like concat('%',#{keyWord},'%') or description like concat('%',#{keyWord},'%') or username like concat('%',#{keyWord},'%'))")
    List<Video> findAllPublicVideoByAudit(String keyWord);


    // 查询所有用户的视频数量,并按照数量降序排列
    @Select("SELECT username, COUNT(*) AS video_num FROM video where auditing = '合格' GROUP BY username ORDER BY video_num DESC")
    List<Map<String, Integer>> getVideoCount();

    // 根据视频类型查询视频
    @Select("select * from video where type=#{value}")
    List<Video> findVideoByType(String type);
}
