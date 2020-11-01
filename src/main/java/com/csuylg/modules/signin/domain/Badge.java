package com.csuylg.modules.signin.domain;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * 徽章信息表构建
 *
 * @author dyf
 */
@Table(name="badge")
public class Badge implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 用户id
	 */
	@Id
    @Column(name = "user_id")
	private Long userId;

	/**
	 * 7天徽章
	 */
    @Column(name = "days7_badge")
	private Integer days7Badge;

	/**
	 * 21天徽章
	 */
    @Column(name = "days21_badge")
	private Integer days21Badge;

	/**
	 * 28天徽章
	 */
    @Column(name = "days28_badge")
	private Integer days28Badge;

	/**
	 * 60天徽章
	 */
    @Column(name = "days60_badge")
	private Integer days60Badge;

	/**
	 * 90天徽章
	 */
    @Column(name = "days90_badge")
	private Integer days90Badge;

	/**
	 * 100天徽章
	 */
    @Column(name = "days100_badge")
	private Integer days100Badge;

	/**
	 * 120天徽章
	 */
    @Column(name = "days120_badge")
	private Integer days120Badge;

	/**
	 * 150天徽章
	 */
    @Column(name = "days150_badge")
	private Integer days150Badge;

	/**
	 * 180天徽章
	 */
    @Column(name = "days180_badge")
	private Integer days180Badge;

	/**
	 * 210天徽章
	 */
    @Column(name = "days210_badge")
	private Integer days210Badge;

	/**
	 * 240天徽章
	 */
    @Column(name = "days240_badge")
	private Integer days240Badge;

	/**
	 * 270天徽章
	 */
    @Column(name = "days270_badge")
	private Integer days270Badge;

	/**
	 * 300天徽章
	 */
    @Column(name = "days300_badge")
	private Integer days300Badge;

	/**
	 * 330天徽章
	 */
    @Column(name = "days330_badge")
	private Integer days330Badge;

	/**
	 * 365天徽章
	 */
    @Column(name = "days365_badge")
	private Integer days365Badge;

	/**
	 * 活跃徽章
	 */
    @Column(name = "activity_badge")
	private Integer activityBadge;

	public Badge() {
	}

	public Badge(Integer days7Badge, Integer days21Badge, Integer days28Badge, Integer days60Badge, Integer days90Badge, Integer days100Badge, Integer days120Badge, Integer days150Badge, Integer days180Badge, Integer days210Badge, Integer days240Badge, Integer days270Badge, Integer days300Badge, Integer days330Badge, Integer days365Badge, Integer activityBadge) {
		this.days7Badge = days7Badge;
		this.days21Badge = days21Badge;
		this.days28Badge = days28Badge;
		this.days60Badge = days60Badge;
		this.days90Badge = days90Badge;
		this.days100Badge = days100Badge;
		this.days120Badge = days120Badge;
		this.days150Badge = days150Badge;
		this.days180Badge = days180Badge;
		this.days210Badge = days210Badge;
		this.days240Badge = days240Badge;
		this.days270Badge = days270Badge;
		this.days300Badge = days300Badge;
		this.days330Badge = days330Badge;
		this.days365Badge = days365Badge;
		this.activityBadge = activityBadge;
	}

	public Badge(Long userId, Integer days7Badge, Integer days21Badge, Integer days28Badge, Integer days60Badge, Integer days90Badge, Integer days100Badge, Integer days120Badge, Integer days150Badge, Integer days180Badge, Integer days210Badge, Integer days240Badge, Integer days270Badge, Integer days300Badge, Integer days330Badge, Integer days365Badge, Integer activityBadge) {
		this.userId = userId;
		this.days7Badge = days7Badge;
		this.days21Badge = days21Badge;
		this.days28Badge = days28Badge;
		this.days60Badge = days60Badge;
		this.days90Badge = days90Badge;
		this.days100Badge = days100Badge;
		this.days120Badge = days120Badge;
		this.days150Badge = days150Badge;
		this.days180Badge = days180Badge;
		this.days210Badge = days210Badge;
		this.days240Badge = days240Badge;
		this.days270Badge = days270Badge;
		this.days300Badge = days300Badge;
		this.days330Badge = days330Badge;
		this.days365Badge = days365Badge;
		this.activityBadge = activityBadge;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Integer getDays7Badge() {
		return days7Badge;
	}

	public void setDays7Badge(Integer days7Badge) {
		this.days7Badge = days7Badge;
	}

	public Integer getDays21Badge() {
		return days21Badge;
	}

	public void setDays21Badge(Integer days21Badge) {
		this.days21Badge = days21Badge;
	}

	public Integer getDays28Badge() {
		return days28Badge;
	}

	public void setDays28Badge(Integer days28Badge) {
		this.days28Badge = days28Badge;
	}

	public Integer getDays60Badge() {
		return days60Badge;
	}

	public void setDays60Badge(Integer days60Badge) {
		this.days60Badge = days60Badge;
	}

	public Integer getDays90Badge() {
		return days90Badge;
	}

	public void setDays90Badge(Integer days90Badge) {
		this.days90Badge = days90Badge;
	}

	public Integer getDays100Badge() {
		return days100Badge;
	}

	public void setDays100Badge(Integer days100Badge) {
		this.days100Badge = days100Badge;
	}

	public Integer getDays120Badge() {
		return days120Badge;
	}

	public void setDays120Badge(Integer days120Badge) {
		this.days120Badge = days120Badge;
	}

	public Integer getDays150Badge() {
		return days150Badge;
	}

	public void setDays150Badge(Integer days150Badge) {
		this.days150Badge = days150Badge;
	}

	public Integer getDays180Badge() {
		return days180Badge;
	}

	public void setDays180Badge(Integer days180Badge) {
		this.days180Badge = days180Badge;
	}

	public Integer getDays210Badge() {
		return days210Badge;
	}

	public void setDays210Badge(Integer days210Badge) {
		this.days210Badge = days210Badge;
	}

	public Integer getDays240Badge() {
		return days240Badge;
	}

	public void setDays240Badge(Integer days240Badge) {
		this.days240Badge = days240Badge;
	}

	public Integer getDays270Badge() {
		return days270Badge;
	}

	public void setDays270Badge(Integer days270Badge) {
		this.days270Badge = days270Badge;
	}

	public Integer getDays300Badge() {
		return days300Badge;
	}

	public void setDays300Badge(Integer days300Badge) {
		this.days300Badge = days300Badge;
	}

	public Integer getDays330Badge() {
		return days330Badge;
	}

	public void setDays330Badge(Integer days330Badge) {
		this.days330Badge = days330Badge;
	}

	public Integer getDays365Badge() {
		return days365Badge;
	}

	public void setDays365Badge(Integer days365Badge) {
		this.days365Badge = days365Badge;
	}

	public Integer getActivityBadge() {
		return activityBadge;
	}

	public void setActivityBadge(Integer activityBadge) {
		this.activityBadge = activityBadge;
	}

	@Override
	public String toString() {
		return "Badge{" +
				"userId=" + userId +
				", days7Badge=" + days7Badge +
				", days21Badge=" + days21Badge +
				", days28Badge=" + days28Badge +
				", days60Badge=" + days60Badge +
				", days90Badge=" + days90Badge +
				", days100Badge=" + days100Badge +
				", days120Badge=" + days120Badge +
				", days150Badge=" + days150Badge +
				", days180Badge=" + days180Badge +
				", days210Badge=" + days210Badge +
				", days240Badge=" + days240Badge +
				", days270Badge=" + days270Badge +
				", days300Badge=" + days300Badge +
				", days330Badge=" + days330Badge +
				", days365Badge=" + days365Badge +
				", activityBadge=" + activityBadge +
				'}';
	}
}
