package com.csuylg.modules.media.dto;

/**
 * 返回的音频或视频信息
 *
 * @author dyf
 */
public class MediaResponse {

    private Long mediaId;
    private String name;
    private String duration;
    private String type;
    private String media;

    public MediaResponse(Long mediaId, String name, String duration, String type, String media) {
        this.mediaId = mediaId;
        this.name = name;
        this.duration = duration;
        this.type = type;
        this.media = media;
    }

    public Long getMediaId() {
        return mediaId;
    }

    public void setMediaId(Long mediaId) {
        this.mediaId = mediaId;
    }

    public String getMedia() {
        return media;
    }

    public void setMedia(String media) {
        this.media = media;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "MediaResponse{" +
                "mediaId=" + mediaId +
                ", name='" + name + '\'' +
                ", duration='" + duration + '\'' +
                ", type='" + type + '\'' +
                ", media='" + media + '\'' +
                '}';
    }
}
