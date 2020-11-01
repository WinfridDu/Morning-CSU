package com.csuylg.modules.signin.mapper;

import com.csuylg.modules.signin.domain.Badge;
import org.apache.ibatis.annotations.Update;
import tk.mybatis.mapper.common.Mapper;

/**
 * 徽章信息的Dao
 *
 * @author dyf
 */
public interface BadgeMapper extends Mapper<Badge> {
    /**
     * 更新徽章数据
     * @param badgeKind 徽章种类
     * @param userId 用户id
     */
    @Update("update badge set ${badgeKind} = ${badgeKind} + 1 where user_id = #{userId}")
    void updateBadge(String badgeKind, Long userId);

    /**
     * 查询徽章数据
     * @param openid openid
     * @return 徽章
     */
    Badge selectBadge(String openid);
}
