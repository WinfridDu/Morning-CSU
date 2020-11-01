package com.csuylg.modules.media.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 媒体文件表构建
 *
 * @author dyf
 */
@Table(name="media_file")
public class MediaFile implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 媒体文件id
	 */
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "media_id")
	private Long mediaId;

	/**
	 * 音视频标题
	 */
    @Column(name = "media_title")
	private String mediaTitle;

	/**
	 * 音视频文件地址
	 */
    @Column(name = "media_url")
	private String mediaUrl;

	/**
	 * 类型，视频/音频
	 */
    @Column(name = "media_type")
	private String mediaType;

	/**
	 * 文本内容
	 */
    @Column(name = "introduction")
	private String introduction;

	/**
	 * 时长
	 */
    @Column(name = "duration")
	private String duration;

	/**
	 * 创建时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name = "create_time")
	private Date createTime;

	/**
	 * 0表示未通过，1表示通过
	 */
    @Column(name = "status")
	private String status;

	public MediaFile(Long mediaId, String mediaTitle, String mediaUrl, String mediaType, String introduction, String duration, Date createTime, String status) {
		this.mediaId = mediaId;
		this.mediaTitle = mediaTitle;
		this.mediaUrl = mediaUrl;
		this.mediaType = mediaType;
		this.introduction = introduction;
		this.duration = duration;
		this.createTime = createTime;
		this.status = status;
	}

	public MediaFile(String mediaTitle, String mediaUrl, String mediaType, String introduction, String duration, Date createTime, String status) {
		this.mediaTitle = mediaTitle;
		this.mediaUrl = mediaUrl;
		this.mediaType = mediaType;
		this.introduction = introduction;
		this.duration = duration;
		this.createTime = createTime;
		this.status = status;
	}

	public MediaFile(String mediaType, String status) {
		this.mediaType = mediaType;
		this.status = status;
	}

	public MediaFile(String status) {
		this.status = status;
	}

	public MediaFile() {}

	public Long getMediaId() {
		return mediaId;
	}

	public void setMediaId(Long mediaId) {
		this.mediaId = mediaId;
	}

	public String getMediaTitle() {
		return mediaTitle;
	}

	public void setMediaTitle(String mediaTitle) {
		this.mediaTitle = mediaTitle;
	}

	public String getMediaUrl() {
		return mediaUrl;
	}

	public void setMediaUrl(String mediaUrl) {
		this.mediaUrl = mediaUrl;
	}

	public String getMediaType() {
		return mediaType;
	}

	public void setMediaType(String mediaType) {
		this.mediaType = mediaType;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
