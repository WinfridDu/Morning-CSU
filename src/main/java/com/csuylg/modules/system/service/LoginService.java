package com.csuylg.modules.system.service;

import com.csuylg.common.utils.DateUtils;
import com.csuylg.modules.signin.controller.SignInController;
import com.csuylg.modules.signin.domain.Badge;
import com.csuylg.modules.signin.domain.SignInRank;
import com.csuylg.modules.signin.mapper.BadgeMapper;
import com.csuylg.modules.signin.mapper.SignInMapper;
import com.csuylg.modules.signin.service.SignInService;
import com.csuylg.modules.system.domain.User;
import com.csuylg.modules.system.dto.LoginResponse;
import com.csuylg.modules.system.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 * 登录校验
 *
 * @author dyf
 */
@Component
public class LoginService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private BadgeMapper badgeMapper;

    @Autowired
    private SignInMapper signInMapper;

    @Autowired
    private SignInService signInService;

    @Autowired
    private UserService userService;

    public LoginResponse login(String openid){
        // 今天是否签到过
        boolean signed = false;
        // 通知是否读过
        boolean read = false;
        // 01标志位每月签到记录
        String recordBits = SignInController.ZERO31;

        User tempUser = new User();
        tempUser.setOpenid(openid);
        User user = userMapper.selectOne(tempUser);

        if(null == user){
            user = new User();
            user.setOpenid(openid);
            user.setLastSignInDate(DateUtils.parseDate("2000-01-01"));
            userMapper.insertSelective(user);

            Badge badge = new Badge();
            badge.setUserId(user.getUserId());
            badgeMapper.insertSelective(badge);
        }else{
            signed = DateUtils.isSameDay(new Date(), user.getLastSignInDate());
            read = user.getNoticeRead() == 1;
            recordBits = signInMapper.selectRecordBitsByMonthAndUserId(DateUtils.getMonth(), user.getUserId());
        }

        //获得排行榜
        List<SignInRank> ranks = signInService.getRanks(user);

        //获得当前签到人数
        int count = userService.selectSignCount();
        return new LoginResponse(signed, openid, ranks.remove(ranks.size()-1), ranks, recordBits, read, count);
    }
}
