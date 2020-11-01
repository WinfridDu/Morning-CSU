package com.csuylg.modules.media.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 构建
 *
 * @author dyf
 */
@Table(name="comment")
public class Comment implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 评论id
	 */
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
	private Long commentId;

	/**
	 * 评论内容
	 */
    @Column(name = "content")
	private String content;

	/**
	 * 媒体文件id
	 */
    @Column(name = "media_id")
	private Long mediaId;

	/**
	 * 用户id
	 */
    @Column(name = "user_id")
	private Long userId;

	/**
	 * 创建时间
	 */
    @Column(name = "create_time")
	private Date createTime;

	public Comment() {
	}

	public Comment(Long commentId, String content, Long mediaId, Long userId, Date createTime) {
		this.commentId = commentId;
		this.content = content;
		this.mediaId = mediaId;
		this.userId = userId;
		this.createTime = createTime;
	}

	public Long getCommentId() {
		return commentId;
	}

	public void setCommentId(Long commentId) {
		this.commentId = commentId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Long getMediaId() {
		return mediaId;
	}

	public void setMediaId(Long mediaId) {
		this.mediaId = mediaId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

}
