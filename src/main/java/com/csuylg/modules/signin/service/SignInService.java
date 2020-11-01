package com.csuylg.modules.signin.service;

import com.csuylg.modules.signin.domain.SignInRank;
import com.csuylg.modules.signin.domain.SignInRecord;
import com.csuylg.modules.signin.dto.Signer;
import com.csuylg.modules.system.domain.User;

import java.util.Date;
import java.util.List;

/**
 * 签到业务层接口
 *
 * @author dyf
 */
public interface SignInService {
    /**
     * 查询签到记录
     * @param signInRecord 签到记录(用户id，月份)
     * @return 签到记录
     */
    SignInRecord selectRecord(SignInRecord signInRecord);

    /**
     * 插入签到记录
     * @param signInRecord 签到记录
     */
    void insertRecord(SignInRecord signInRecord);

    /**
     * 更新签到记录
     * @param signInRecord 签到记录
     */
    void updateRecord(SignInRecord signInRecord);

    /**
     * 获得排行榜，排行榜后附加自己的排名
     * @param user 用户信息
     * @return 排行榜
     */
    List<SignInRank> getRanks(User user);

    /**
     * 签到，更改或新增签到数据
     * @param userId 用户id
     * @param nowDate 当前时间
     * @param isContinuous 是否连续
     * @param toSign 是否需要签到
     * @return 签到数据
     */
    SignInRecord signIn(Long userId, Date nowDate, boolean isContinuous, boolean toSign);

    /**
     * 查询该月签到列表
     * @param month 月份
     * @return 签到记录列表
     */
    List<Signer> selectList(String month);
}
