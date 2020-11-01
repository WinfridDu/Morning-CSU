package com.csuylg.modules.signin.service.impl;

import com.csuylg.modules.signin.domain.Badge;
import com.csuylg.modules.signin.dto.BadgeInfo;
import com.csuylg.modules.signin.mapper.BadgeMapper;
import com.csuylg.modules.signin.service.BadgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 徽章业务层接口实现类
 *
 * @author dyf
 */
@Service
public class BadgeServiceImpl implements BadgeService {
    private static final Integer[] BADGE_KIND = new Integer[]{7, 21, 28, 60, 90, 100, 120, 150, 180, 210, 240, 270, 300, 330, 365};
    private static final Set<Integer> BADGE_SET = new HashSet<>(Arrays.asList(BADGE_KIND));

    @Autowired
    private BadgeMapper badgeMapper;

    @Override
    public BadgeInfo updateBadge(int totalContinuousCount, int continuousCount, Long userId) {
        BadgeInfo badgeInfo = new BadgeInfo(BADGE_SET.contains(totalContinuousCount), 28 == continuousCount);
        if(badgeInfo.getGetNormalBadge()){
            badgeMapper.updateBadge("days" + totalContinuousCount + "_badge", userId);
        }
        if(badgeInfo.getGetActivityBadge()){
            badgeMapper.updateBadge("activity_badge", userId);
        }
        return badgeInfo;
    }

    @Override
    public Badge selectBadge(String openid) {
        return badgeMapper.selectBadge(openid);
    }
}
