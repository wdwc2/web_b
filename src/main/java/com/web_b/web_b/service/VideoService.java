package com.web_b.web_b.service;

import com.web_b.web_b.pojo.PageBean;
import com.web_b.web_b.pojo.Video;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@Service
public interface VideoService {

    // 上传视频
    void  uploadVideo(Video video, MultipartFile file) throws Exception;

    // 根据上传者查询视频
    Video[] findVideoByUserName(String userName);

    // 根据视频名编辑视频
    void editVideoByName(Video video);

    // 根据视频名删除视频
    void deleteVideoByName(String filePath);

    // 查询所有用户上传的视频
    List<Video> findAllVideo();

    // 分页查询所有用户上传的视频
    PageBean findAllVideoByPage(Integer start, Integer end);

    // 查询所有用户上传的视频的数量
    void deleteVideoByNames(List<String> filePaths);

    Video findVideoByPath(String filePath);


    void checkVideo(String filePath, String auditing, String violationReason);

    List<Video> findAllPublicVideoByAudit(String keyWord);


    List<Map<String, Integer>> getVideoCount();


    List<Video> findVideoByType(String type);
}
