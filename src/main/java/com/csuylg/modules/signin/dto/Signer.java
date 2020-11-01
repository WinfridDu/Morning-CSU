package com.csuylg.modules.signin.dto;

import com.csuylg.common.annotation.Excel;

/**
 * 每月签到记录
 *
 * @author dyf
 */
public class Signer{
    /**
     * 用户昵称
     */
    @Excel(name = "用户昵称")
    private String nickName;
    /**
     * 用户头像地址
     */
    @Excel(name = "头像地址")
    private String avatarUrl;
    /**
     * 当月打卡数目
     */
    @Excel(name = "当月打卡数目")
    private int counts;
    /**
     * 总打卡数目
     */
    @Excel(name = "总打卡数目")
    private int totalCounts;
    /**
     * 当月使用微信小程序的时间（每天打卡时间点毫秒数总和）
     */
    @Excel(name = "当月使用微信小程序的时间")
    private int milliseconds;

    public Signer() {
    }

    public Signer(String nickName, String avatarUrl, int counts, int totalCounts, int milliseconds) {
        this.nickName = nickName;
        this.avatarUrl = avatarUrl;
        this.counts = counts;
        this.totalCounts = totalCounts;
        this.milliseconds = milliseconds;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public int getCounts() {
        return counts;
    }

    public void setCounts(int counts) {
        this.counts = counts;
    }

    public int getTotalCounts() {
        return totalCounts;
    }

    public void setTotalCounts(int totalCounts) {
        this.totalCounts = totalCounts;
    }

    public int getMilliseconds() {
        return milliseconds;
    }

    public void setMilliseconds(int milliseconds) {
        this.milliseconds = milliseconds;
    }
}
