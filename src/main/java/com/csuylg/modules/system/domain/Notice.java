package com.csuylg.modules.system.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 通知公告构建
 *
 * @author dyf
 */
@Table(name="notice")
public class Notice implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 公告ID
	 */
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "notice_id")
	private Integer noticeId;

	/**
	 * 公告标题
	 */
    @Column(name = "notice_title")
	private String noticeTitle;

	/**
	 * 公告内容
	 */
	@Column(name = "notice_content")
	private String noticeContent;

	/**
	 * 创建时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name = "create_time")
	private Date createTime;

	public Notice(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}

	public Notice(String noticeTitle, String noticeContent, Date createTime) {
		this.noticeTitle = noticeTitle;
		this.noticeContent = noticeContent;
		this.createTime = createTime;
	}

	public Notice(Integer noticeId, String noticeTitle, String noticeContent, java.sql.Date createTime) {
		this.noticeId = noticeId;
		this.noticeTitle = noticeTitle;
		this.noticeContent = noticeContent;
		this.createTime = createTime;
	}

	public Integer getNoticeId() {
		return noticeId;
	}

	public void setNoticeId(Integer noticeId) {
		this.noticeId = noticeId;
	}

	public String getNoticeTitle() {
		return noticeTitle;
	}

	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getNoticeContent() {
		return noticeContent;
	}

	public void setNoticeContent(String noticeContent) {
		this.noticeContent = noticeContent;
	}
}
