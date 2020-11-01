package com.csuylg.modules.signin.mapper;

import com.csuylg.modules.signin.domain.SignInRank;
import com.csuylg.modules.signin.domain.SignInRecord;
import com.csuylg.modules.signin.dto.Signer;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * 每月签到数据的Dao
 *
 * @author dyf
 */
public interface SignInMapper extends Mapper<SignInRecord> {

    /**
     * 查询某月排名
     * @param month 查询月份
     * @return 排名
     */
    List<SignInRank> selectSignInRank(String month);

    /**
     * 查询签到记录
     * @param openid openid
     * @param month 月份
     * @return 签到记录
     */
    @Select("select s.* from sign_in_record s INNER JOIN user u on s.user_id = u.user_id and u.openid = #{openid} and s.month = #{month}")
    SignInRecord selectRecord(String openid, String month);

    /**
     * 查询签到记录
     * @param month 月份
     * @param userId 用户Id
     * @return 签到记录
     */
    @Select("select record_bits from sign_in_record where month = #{month} and user_id = #{userId}")
    String selectRecordBitsByMonthAndUserId(String month, Long userId);

    /**
     * 查询该月签到记录
     * @param month 月份
     * @return 签到记录
     */
    List<Signer> selectList(String month);
}
