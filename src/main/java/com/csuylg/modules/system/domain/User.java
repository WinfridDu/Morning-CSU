package com.csuylg.modules.system.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 构建用户信息类
 *
 * @author dyf
 */
@Table(name="user")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 用户ID
	 */
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
	private Long userId;

	/**
	 * 微信ID
	 */
    @Column(name = "openid")
	private String openid;

	/**
	 * 微信昵称
	 */
    @Column(name = "nick_name")
	private String nickName;

	/**
	 * 头像地址
	 */
    @Column(name = "avatar")
	private String avatar;

	/**
	 * 上次签到日期
	 */
	@JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name = "last_sign_in_date")
	private Date lastSignInDate;

	/**
	 * 总签到次数
	 */
    @Column(name = "total_counts")
	private Integer totalCounts;

	/**
	 * 总连续签到次数
	 */
    @Column(name = "total_continuous_counts")
	private Integer totalContinuousCounts;

	/**
	 * 通知是否已读(0未读,1已读)
	 */
    @Column(name = "notice_read")
	private Integer noticeRead;

	public User() {
	}

	public User(String openid) {
		this.openid = openid;
	}

	public User(String openid, String nickName, String avatar) {
		this.openid = openid;
		this.nickName = nickName;
		this.avatar = avatar;
	}

	public User(Long userId, String openid, String nickName, String avatar, Date lastSignInDate, Integer totalCounts, Integer totalContinuousCounts, Integer noticeRead) {
		this.userId = userId;
		this.openid = openid;
		this.nickName = nickName;
		this.avatar = avatar;
		this.lastSignInDate = lastSignInDate;
		this.totalCounts = totalCounts;
		this.totalContinuousCounts = totalContinuousCounts;
		this.noticeRead = noticeRead;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public Date getLastSignInDate() {
		return lastSignInDate;
	}

	public void setLastSignInDate(Date lastSignInDate) {
		this.lastSignInDate = lastSignInDate;
	}

	public Integer getTotalCounts() {
		return totalCounts;
	}

	public void setTotalCounts(Integer totalCounts) {
		this.totalCounts = totalCounts;
	}

	public Integer getTotalContinuousCounts() {
		return totalContinuousCounts;
	}

	public void setTotalContinuousCounts(Integer totalContinuousCounts) {
		this.totalContinuousCounts = totalContinuousCounts;
	}

	public Integer getNoticeRead() {
		return noticeRead;
	}

	public void setNoticeRead(Integer noticeRead) {
		this.noticeRead = noticeRead;
	}

}
