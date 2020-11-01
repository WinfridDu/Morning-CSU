package com.csuylg.modules.signin.dto;

import com.csuylg.modules.media.dto.MediaResponse;
import com.csuylg.modules.signin.domain.SignInRank;

import java.util.List;

/**
 * 用户签到返回类
 *
 * @author dyf
 */
public class SignInResponse {
    /**
     * 该月连续签到天数
     */
    private Integer counts;
    /**
     * 用户排名
     */
    private SignInRank userRank;
    /**
     * 签到排行榜
     */
    private List<SignInRank> list;
    /**
     * 音视频信息
     */
    private MediaResponse latestSound;
    /**
     * 该月具体签到天数,数据用于小程序端日历渲染
     */
    private String detailDates;
    /**
     * 是否获得徽章
     */
    private BadgeInfo badgeInfo;
    /**
     * 当天签到人次
     */
    private Integer signedNum;

    public SignInResponse() {
    }

    public SignInResponse(Integer counts, Integer signedNum) {
        this.counts = counts;
        this.signedNum = signedNum;
    }

    public int getCounts() {
        return counts;
    }

    public void setCounts(int counts) {
        this.counts = counts;
    }

    public SignInRank getUserRank() {
        return userRank;
    }

    public void setUserRank(SignInRank userRank) {
        this.userRank = userRank;
    }

    public List<SignInRank> getList() {
        return list;
    }

    public void setList(List<SignInRank> list) {
        this.list = list;
    }

    public MediaResponse getLatestSound() {
        return latestSound;
    }

    public void setLatestSound(MediaResponse latestSound) {
        this.latestSound = latestSound;
    }

    public String getDetailDates() {
        return detailDates;
    }

    public void setDetailDates(String detailDates) {
        this.detailDates = detailDates;
    }

    public BadgeInfo getBadgeInfo() {
        return badgeInfo;
    }

    public void setBadgeInfo(BadgeInfo badgeInfo) {
        this.badgeInfo = badgeInfo;
    }

    public int getSignedNum() {
        return signedNum;
    }

    public void setSignedNum(int signedNum) {
        this.signedNum = signedNum;
    }
}
