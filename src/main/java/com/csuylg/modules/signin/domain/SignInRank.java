package com.csuylg.modules.signin.domain;

/**
 * 用户排名信息类
 *
 * @author dyf
 */
public class SignInRank {
    /**
     * 用户排名
     */
    private int rank;
    /**
     * 用户昵称
     */
    private String nickName;
    /**
     * 用户头像地址
     */
    private String avatarUrl;
    /**
     * 该月总签到天数
     */
    private int currentCounts;
    /**
     * 该月连续签到天数
     */
    private int continuousCounts;
    /**
     * 用户ID
     */
    private Long userId;

    public SignInRank(Long userId, String nickName, String avatarUrl, int currentCounts, int continuousCounts) {
        this.userId = userId;
        this.nickName = nickName;
        this.avatarUrl = avatarUrl;
        this.currentCounts = currentCounts;
        this.continuousCounts = continuousCounts;
    }

    public SignInRank(int rank, String nickName, String avatarUrl, int currentCounts, int continuousCounts, Long userId) {
        this.rank = rank;
        this.nickName = nickName;
        this.avatarUrl = avatarUrl;
        this.currentCounts = currentCounts;
        this.continuousCounts = continuousCounts;
        this.userId = userId;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
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

    public int getCurrentCounts() {
        return currentCounts;
    }

    public void setCurrentCounts(int currentCounts) {
        this.currentCounts = currentCounts;
    }

    public int getContinuousCounts() {
        return continuousCounts;
    }

    public void setContinuousCounts(int continuousCounts) {
        this.continuousCounts = continuousCounts;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "SignInRank{" +
                "rank=" + rank +
                ", nickName='" + nickName + '\'' +
                ", avatarUrl='" + avatarUrl + '\'' +
                ", currentCounts=" + currentCounts +
                ", continuousCounts=" + continuousCounts +
                ", userId=" + userId +
                '}';
    }
}
