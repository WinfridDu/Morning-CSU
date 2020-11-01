package com.csuylg.modules.media.controller;

import com.csuylg.common.utils.FileUploadUtils;
import com.csuylg.common.utils.Md5Utils;
import com.csuylg.common.web.CommonResponse;
import com.csuylg.config.MorningConfig;
import com.csuylg.modules.media.domain.MediaFile;
import com.csuylg.modules.media.dto.MediaResponse;
import com.csuylg.modules.media.service.MediaFileService;
import com.github.pagehelper.PageHelper;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.exceptions.CannotReadException;
import org.jaudiotagger.audio.exceptions.InvalidAudioFrameException;
import org.jaudiotagger.audio.exceptions.ReadOnlyFileException;
import org.jaudiotagger.audio.mp3.MP3AudioHeader;
import org.jaudiotagger.audio.mp3.MP3File;
import org.jaudiotagger.tag.TagException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * 媒体文件控制层
 *
 * @author dyf
 */
@RestController
public class MediaFileController {
    @Autowired
    private MediaFileService mediaFileService;

    /**
     * 上传音视频
     * @param video 视频文件
     * @param sound 音频文件
     * @param name 标题
     * @param intro 介绍
     */
    @PostMapping("/UploadServlet")
    public void add(MultipartFile video, MultipartFile sound, String name, String intro) throws IOException{
        String filePath;
        String mediaType;
        String duration = "00:00";
        if(sound != null){
            String fileName = Md5Utils.hash(name) + ".mp3";
            filePath = FileUploadUtils.upload(MorningConfig.getAudioPath(), sound, fileName);
            mediaType = "sound";
            try {
                // 获取音频时长
                MP3File mp3File = (MP3File) AudioFileIO.read(
                        FileUploadUtils.getAbsoluteFile(MorningConfig.getAudioPath(), fileName));
                MP3AudioHeader mp3AudioHeader = (MP3AudioHeader) mp3File.getAudioHeader();
                duration = mp3AudioHeader.getTrackLengthAsString();
            } catch (CannotReadException | InvalidAudioFrameException | ReadOnlyFileException | TagException e) {
                e.printStackTrace();
            }
        }else{
            filePath = FileUploadUtils.upload(MorningConfig.getVideoPath(), video, Md5Utils.hash(name) + ".mp4");
            mediaType = "video";
        }
        mediaFileService.insertMediaFile(new MediaFile(name, filePath, mediaType, intro, duration, new Date(), "0"));
    }

    /**
     * 响应管理员审核音频文件通过
     */
    @GetMapping("/PassServlet")
    public CommonResponse auditPass(Long mediaId){
        MediaFile mediaFile = new MediaFile();
        mediaFile.setMediaId(mediaId);
        mediaFile.setStatus("1");
        mediaFileService.updateMediaFile(mediaFile);
        return CommonResponse.success();
    }

    /**
     * 响应用户请求音视频文件操作
     */
    @GetMapping("/GetSrcServlet")
    public List<MediaResponse> list(String req, Integer page){
        switch (req){
            case "sound":
                PageHelper.startPage(page, 15);
                return mediaFileService.selectMediaList(new MediaFile("sound", "1"));
            case "video":
                PageHelper.startPage(page, 15);
                return mediaFileService.selectMediaList(new MediaFile("video", "1"));
            case "root":
                PageHelper.startPage(page, 15);
                return mediaFileService.selectMediaList(new MediaFile("sound", "0"));
            default:
                PageHelper.startPage(1, 10);
                return mediaFileService.selectMediaList(new MediaFile("1"));
        }
    }

    /**
     * 响应用户请求音视频文件时，返回音频正文
     */
    @GetMapping("/IntroServlet")
    public String getIntroduction(Long mediaId){
        return mediaFileService.selectIntroById(mediaId);
    }

    /**
     * 响应管理员删除音频文件操作
     */
    @GetMapping("/DeleteServlet")
    public CommonResponse remove(Long mediaId){
        mediaFileService.deleteMediaFileById(mediaId);
        return CommonResponse.success();
    }
}
