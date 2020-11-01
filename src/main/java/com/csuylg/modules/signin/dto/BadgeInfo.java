package com.csuylg.modules.signin.dto;

/**
 * 是否获得新徽章
 *
 * @author dyf
 */
public class BadgeInfo {
    private Boolean getNormalBadge;
    private Boolean getActivityBadge;

    public BadgeInfo(Boolean getNormalBadge, Boolean getActivityBadge) {
        this.getNormalBadge = getNormalBadge;
        this.getActivityBadge = getActivityBadge;
    }

    public Boolean getGetNormalBadge() {
        return getNormalBadge;
    }

    public void setGetNormalBadge(Boolean getNormalBadge) {
        this.getNormalBadge = getNormalBadge;
    }

    public Boolean getGetActivityBadge() {
        return getActivityBadge;
    }

    public void setGetActivityBadge(Boolean getActivityBadge) {
        this.getActivityBadge = getActivityBadge;
    }
}
