package com.web_b.web_b.controller;

import com.web_b.web_b.pojo.Result;
import com.web_b.web_b.pojo.Video;
import com.web_b.web_b.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class VideoController {

    @Autowired
    private VideoService videoService;

    @RequestMapping("/updateVideo")// 上传视频
    public Result updateVideo(Video video, MultipartFile file) throws Exception {
        //System.out.println(video);
        //System.out.println(file);
        // 调用service，上传视频
        videoService.uploadVideo(video, file);
        return new Result(200, "ok", null);
    }

    // 根据上传者查询视频
    @GetMapping("/findVideoByUserName")
    public Result findVideoByUserName(String userName) {
        // 调用service，查询视频
        Video[] videos = videoService.findVideoByUserName(userName);
        return new Result(200, "ok", videos);
    }

    // 根据视频名编辑视频
    @RequestMapping("/editVideoByName")
    public Result editVideoByName(@RequestBody Video video) {
        // System.out.println(video);
        // 调用service，编辑视频
        videoService.editVideoByName(video);
        return new Result(200, "ok", null);
    }

    // 根据视频名删除视频
    @GetMapping("/deleteVideoByName")
    public Result deleteVideoByName(String filePath) {
        // System.out.println(filePath);
        // 调用service，删除视频
        videoService.deleteVideoByName(filePath);
        return new Result(200, "ok", null);
    }

    // 根据视频名批量删除视频
    @RequestMapping("/deleteVideoByNames")
    public Result deleteVideoByNames(@RequestBody List<String> filePaths) {
        System.out.println(filePaths);
        // 调用service，删除视频
        videoService.deleteVideoByNames(filePaths);
        return new Result(200, "ok", null);
    }

    // 查询所有用户上传的视频
    @GetMapping("/findAllVideo")
    public Result findAllVideo() {
        // 调用service，查询视频
        List<Video> videos = videoService.list();
        return new Result(200, "ok", videos);
    }

    // 分页查询所有用户上传的视频
//    @GetMapping("/findAllVideoByPage")
//    public Result findAllVideoByPage(@RequestParam(defaultValue = "1") Integer page,
//                                     @RequestParam(defaultValue = "10") Integer limit) {
////        System.out.println(page);
////        System.out.println(limit);
//        // 调用service，查询视频
//        PageBean pageBeans = videoService.findAllVideoByPage(page, limit);
//        return new Result(200, "ok", pageBeans);
//    }

    // 从所有视频中查询公开且审核为合格视频，按视频上传时间降序排列，模糊查询
    @GetMapping("/findAllPublicVideoByAudit")
    public Result findAllPublicVideoByAudit(String detail) {
        // 调用service，查询视频
        List<Video> videos = videoService.findAllPublicVideoByAudit(detail);
        return new Result(200, "ok", videos);
    }

    // 从所有视频中查询每个人公开且审核为合格视频数量
    @RequestMapping("/getVideoCount")
    public Result getVideoCount() {
        // 调用service，将结果封装到list中
        List<Map<String, Integer>> list = videoService.getVideoCount();
        return new Result(200, "ok", list);
    }


    // 根据视频路径查询视频
    @GetMapping("/video")
    public Result findVideoByPath(@RequestParam("id") String filePath) {
        // 调用service，查询视频
        Video video = videoService.findVideoByPath(filePath);
        return new Result(200, "ok", video);
    }

    // 根据视频路径审核视频
    @GetMapping("/checkVideo")
    public Result checkVideo(@RequestParam("id") String filePath, @RequestParam("auditing") String auditing, @RequestParam("violationReason") String violationReason) {
        // 调用service，审核视频
        // System.out.println(violationReason);
        // 如果审核不合格，将违规原因写入数据库
        videoService.checkVideo(filePath, auditing, violationReason);
        return new Result(200, "ok", null);
    }

    // 根据类型查询视频
    @GetMapping("/findVideoByType")
    public Result findVideoByType(String type) {
        // 调用service，查询视频
        List<Video> videos = videoService.findVideoByType(type);
        return new Result(200, "ok", videos);
    }
}
