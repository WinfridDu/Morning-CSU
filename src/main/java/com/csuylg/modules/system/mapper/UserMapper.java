package com.csuylg.modules.system.mapper;

import com.csuylg.modules.system.domain.User;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;
import tk.mybatis.mapper.common.Mapper;

/**
 * 用户信息dao层
 *
 * @author dyf
 */
public interface UserMapper extends Mapper<User> {
    /**
     * 查询用户id
     * @param openid openid
     * @return 用户id
     */
    @Select("select user_id from user where openid = #{openid}")
    Long selectUserIdByOpenid(String openid);

    /**
     * 更新用户头像和昵称
     * @param user 用户对象
     */
    @Update("update user set nick_name = #{nickName}, avatar = #{avatar} where openid = #{openid}")
    @SelectKey(statement = "select user_id from user where openid = #{openid}", keyProperty = "userId", before = true, resultType = Long.class)
    void updateUser(User user);

    /**
     * 更新用户的通知阅读状态
     * @param openid openid
     * @param status 状态
     */
    @Update("update user set notice_read = #{status} where openid = #{openid}")
    void updateStatus(String openid, String status);
}
