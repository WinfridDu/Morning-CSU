package com.csuylg.modules.system.dto;

import com.csuylg.modules.signin.domain.SignInRank;

import java.util.List;

/**
 * 登录相应类
 *
 * @author dyf
 */
public class LoginResponse {
    private boolean signIn;
    private String openid;
    private SignInRank userRank;
    private List<SignInRank> userRankList;
    private String detailDates;
    private boolean isread;
    private int signedNum;

    public LoginResponse(boolean signIn, String openid, SignInRank userRank, List<SignInRank> userRankList, String detailDates, boolean isread, int signedNum) {
        this.signIn = signIn;
        this.openid = openid;
        this.userRank = userRank;
        this.userRankList = userRankList;
        this.detailDates = detailDates;
        this.isread = isread;
        this.signedNum = signedNum;
    }

    public boolean isSignIn() {
        return signIn;
    }

    public void setSignIn(boolean signIn) {
        this.signIn = signIn;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public SignInRank getUserRank() {
        return userRank;
    }

    public void setUserRank(SignInRank userRank) {
        this.userRank = userRank;
    }

    public List<SignInRank> getUserRankList() {
        return userRankList;
    }

    public void setUserRankList(List<SignInRank> userRankList) {
        this.userRankList = userRankList;
    }

    public String getDetailDates() {
        return detailDates;
    }

    public void setDetailDates(String detailDates) {
        this.detailDates = detailDates;
    }

    public boolean isIsread() {
        return isread;
    }

    public void setIsread(boolean isread) {
        this.isread = isread;
    }

    public int getSignedNum() {
        return signedNum;
    }

    public void setSignedNum(int signedNum) {
        this.signedNum = signedNum;
    }
}
