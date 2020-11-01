package com.csuylg.modules.system.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 构建
 *
 * @author dyf
 */
@Table(name="notice_img")
public class NoticeImg implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 通知图片id
	 */
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "notice_img_id")
	private Long noticeImgId;

	/**
	 * 通知图片地址
	 */
    @Column(name = "notice_img_url")
	private String noticeImgUrl;

	/**
	 * 通知id
	 */
    @Column(name = "notice_id")
	private Integer noticeId;

	public NoticeImg(String noticeImgUrl, Integer noticeId) {
		this.noticeImgUrl = noticeImgUrl;
		this.noticeId = noticeId;
	}

	public NoticeImg(Long noticeImgId, String noticeImgUrl, Integer noticeId) {
		this.noticeImgId = noticeImgId;
		this.noticeImgUrl = noticeImgUrl;
		this.noticeId = noticeId;
	}

	public Long getNoticeImgId() {
		return noticeImgId;
	}

	public void setNoticeImgId(Long noticeImgId) {
		this.noticeImgId = noticeImgId;
	}

	public String getNoticeImgUrl() {
		return noticeImgUrl;
	}

	public void setNoticeImgUrl(String noticeImgUrl) {
		this.noticeImgUrl = noticeImgUrl;
	}

	public Integer getNoticeId() {
		return noticeId;
	}

	public void setNoticeId(Integer noticeId) {
		this.noticeId = noticeId;
	}

}
