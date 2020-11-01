package com.csuylg.modules.signin.domain;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * 每月签到数据构建
 *
 * @author dyf
 */
@Table(name="sign_in_record")
public class SignInRecord implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "record_id")
	private Long recordId;
	/**
	 * 用户id
	 */
    @Column(name = "user_id")
	private Long userId;

	/**
	 * 月份，用年+月表示，如(202010)
	 */
    @Column(name = "month")
	private String month;

	/**
	 * 该月签到次数
	 */
    @Column(name = "counts")
	private Integer counts;

	/**
	 * 签到毫秒数，用于签到次数相同时的排序
	 */
    @Column(name = "milliseconds")
	private Integer milliseconds;

	/**
	 * 该月连续签到次数
	 */
    @Column(name = "continuous_counts")
	private Integer continuousCounts;

	/**
	 * 31位标志每月签到记录
	 */
    @Column(name = "record_bits")
	private String recordBits;

	public SignInRecord() {
	}

	public SignInRecord(Long userId, String month) {
		this.userId = userId;
		this.month = month;
	}

	public SignInRecord(Long recordId, Long userId, String month, Integer counts, Integer milliseconds, Integer continuousCounts, String recordBits) {
		this.recordId = recordId;
		this.userId = userId;
		this.month = month;
		this.counts = counts;
		this.milliseconds = milliseconds;
		this.continuousCounts = continuousCounts;
		this.recordBits = recordBits;
	}

	public Long getRecordId() {
		return recordId;
	}

	public void setRecordId(Long recordId) {
		this.recordId = recordId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public Integer getCounts() {
		return counts;
	}

	public void setCounts(Integer counts) {
		this.counts = counts;
	}

	public Integer getMilliseconds() {
		return milliseconds;
	}

	public void setMilliseconds(Integer milliseconds) {
		this.milliseconds = milliseconds;
	}

	public Integer getContinuousCounts() {
		return continuousCounts;
	}

	public void setContinuousCounts(Integer continuousCounts) {
		this.continuousCounts = continuousCounts;
	}

	public String getRecordBits() {
		return recordBits;
	}

	public void setRecordBits(String recordBits) {
		this.recordBits = recordBits;
	}

}
