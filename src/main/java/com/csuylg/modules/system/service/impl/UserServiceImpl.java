package com.csuylg.modules.system.service.impl;

import com.csuylg.common.utils.DateUtils;
import com.csuylg.modules.system.domain.User;
import com.csuylg.modules.system.mapper.UserMapper;
import com.csuylg.modules.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;

/**
 * 用户业务层接口实现类
 *
 * @author dyf
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public void updateStatus(String openid, String status) {
        userMapper.updateStatus(openid, status);
    }

    @Override
    public void updateUser(User user) {
        userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public Long updateUserByOpenid(String openid, String nickName, String avatar) {
        User user = new User(openid, nickName, avatar);
        userMapper.updateUser(user);
        return user.getUserId();
    }

    @Override
    public User selectUser(User user) {
        return userMapper.selectOne(user);
    }

    @Override
    public int selectSignCount() {
        //获得当前签到人数
        User temp = new User();
        temp.setLastSignInDate(DateUtils.truncate(new Date(), Calendar.DATE));
        return userMapper.selectCount(temp);
    }
}
