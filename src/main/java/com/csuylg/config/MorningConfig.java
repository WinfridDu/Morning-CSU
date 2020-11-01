package com.csuylg.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 读取项目相关配置
 * 
 * @author dyf
 */
@Component
@ConfigurationProperties(prefix = "morning")
public class MorningConfig {
    /** 上传路径 */
    private static String profile;

    public static String getProfile()
    {
        return profile;
    }

    public void setProfile(String profile)
    {
        MorningConfig.profile = profile;
    }

    /**
     * 获取通知图片上传路径
     */
    public static String getNoticeImgPath() {
        return getProfile() + "/activity/";
    }

    /**
     * 获取音频上传路径
     */
    public static String getAudioPath() {
        return getProfile() + "/sound";
    }

    /**
     * 获取视频上传路径
     */
    public static String getVideoPath() {
        return getProfile() + "/video";
    }

    /**
     * 获取下载路径
     */
    public static String getDownloadPath() {
        return getProfile() + "/download/";
    }
}