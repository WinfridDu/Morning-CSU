package com.csuylg.modules.signin.service;

import com.csuylg.modules.signin.domain.Badge;
import com.csuylg.modules.signin.dto.BadgeInfo;

/**
 * 徽章业务层接口
 *
 * @author dyf
 */
public interface BadgeService {
    /**
     * 更新徽章
     * @param totalContinuousCount 总连续签到次数
     * @param continuousCount 该月连续签到次数
     * @param userId 用户id
     * @return BadgeInfo 徽章是否更新数据
     */
    BadgeInfo updateBadge(int totalContinuousCount, int continuousCount, Long userId);

    /**
     * 查询用户徽章数据
     * @param openid openid
     * @return 徽章数据
     */
    Badge selectBadge(String openid);
}
