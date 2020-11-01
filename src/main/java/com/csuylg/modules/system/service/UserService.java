package com.csuylg.modules.system.service;

import com.csuylg.modules.system.domain.User;

/**
 * 用户业务层接口
 *
 * @author dyf
 */
public interface UserService {
    /**
     * 更新用户
     * @param openid 用户id
     * @param status 通知阅读状态
     */
    void updateStatus(String openid, String status);

    /**
     * 更新用户
     * @param user 用户
     */
    void updateUser(User user);

    /**
     * 更新用户
     * @param openid openid
     * @param nickName 昵称
     * @param avatar 头像
     * @return 用户对象id
     */
    Long updateUserByOpenid(String openid, String nickName, String avatar);

    /**
     * 查询用户
     * @param user 用户条件
     * @return 用户
     */
    User selectUser(User user);

    /**
     * 查询当天已签到人数
     * @return 签到人数
     */
    int selectSignCount();
}
