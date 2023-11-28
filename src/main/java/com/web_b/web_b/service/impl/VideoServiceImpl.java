package com.web_b.web_b.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.web_b.web_b.mapper.VideoMapper;
import com.web_b.web_b.pojo.Video;
import com.web_b.web_b.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class VideoServiceImpl
        extends ServiceImpl<VideoMapper, Video>
        implements VideoService {

    @Autowired // 注入mapper
    private VideoMapper videoMapper;

    @Override
    // 上传视频
    public void  uploadVideo(Video video, MultipartFile file) throws Exception {
        // 获取文件名
        String originalFilename = file.getOriginalFilename();
        // System.out.println(originalFilename);
        // 获取文件后缀
        String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));
        // 生成新的文件名
        String newFileName = UUID.randomUUID().toString() + suffix;
        // 保存到磁盘
        file.transferTo(new File("D:\\javacode\\web-b\\src\\assets\\" + newFileName));
        // 设置视频的上传时间
        video.setUploadTime(LocalDateTime.now());
        // 文件路径
        video.setFilePath(newFileName);
        System.out.println(video);
        // 上传视频mapper
        videoMapper.uploadVideo(video);
    }


    @Override
    public Video[] findVideoByUserName(String userName) {
        // 调用mapper，查询视频
        return videoMapper.findVideoByUserName(userName);
    }

    @Override
    public void editVideoByName(Video video) {
        // 获取当前时间
        video.setUploadTime(LocalDateTime.now());
        // System.out.println(video);
        // 调用mapper，编辑视频
        videoMapper.editVideoByName(video);
    }

    // 根据视频名删除视频
    @Override
    public void deleteVideoByName(String file_path) {
        // 调用mapper，删除数据库中的视频信息
        videoMapper.deleteVideoByName(file_path);
        // 删除磁盘中的视频
        File file = new File("D:\\javacode\\web-b\\src\\assets\\" + file_path);
        file.delete();
    }



//    @Override
//    public PageBean findAllVideoByPage(Integer page, Integer limit) {
//        // 获取总记录数
//        Long count = videoMapper.findAllVideoCount();
//        // 计算起始索引
//        Integer start = (page - 1) * limit;
//
//        // 调用mapper，查询视频
//        List<Video> videos = videoMapper.findAllVideoByPage(start, limit);
//
//        // 封装PageBean
//        return new PageBean(count, videos);
//    }


    @Override
    public void deleteVideoByNames(List<String> filePaths) {
        // 调用mapper，删除视频
        videoMapper.deleteVideoByNames(filePaths);
    }

    // 根据视频路径查询视频
    @Override
    public Video findVideoByPath(String filePath) {
        // 调用mapper，查询视频
        return videoMapper.findVideoByPath(filePath);
    }

    // 根据视频路径审核视频
    @Override
    public void checkVideo(String filePath, String auditing, String violationReason) {
        // 调用mapper，审核视频
        videoMapper.checkVideo(filePath, auditing, violationReason);
    }

    // 从所有视频中查询公开且审核为合格视频，按视频上传时间降序排列
    @Override
    public List<Video> findAllPublicVideoByAudit(String keyWord) {
        // 调用mapper，查询视频
        return videoMapper.findAllPublicVideoByAudit(keyWord);
    }

    // 从所有视频中查询每个人公开且审核为合格视频数量
    @Override
    public List<Map<String, Integer>> getVideoCount() {
        // 调用mapper，将结果封装到list中
        return videoMapper.getVideoCount();
    }

    @Override
    public List<Video> findVideoByType(String type) {
        // 调用mapper，查询视频
        return videoMapper.findVideoByType(type);
    }
}
