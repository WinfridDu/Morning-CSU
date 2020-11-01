package com.csuylg.modules.signin.service.impl;

import com.csuylg.common.utils.DateUtils;
import com.csuylg.common.utils.StringUtils;
import com.csuylg.modules.signin.controller.SignInController;
import com.csuylg.modules.signin.domain.SignInRank;
import com.csuylg.modules.signin.domain.SignInRecord;
import com.csuylg.modules.signin.dto.Signer;
import com.csuylg.modules.signin.mapper.SignInMapper;
import com.csuylg.modules.signin.service.SignInService;
import com.csuylg.modules.system.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * 签到业务层接口实现类
 *
 * @author dyf
 */
@Service
public class SignInServiceImpl implements SignInService {
    @Autowired
    private SignInMapper signInMapper;

    @Override
    public SignInRecord selectRecord(SignInRecord signInRecord) {
        return signInMapper.selectByPrimaryKey(signInRecord);
    }

    @Override
    public void insertRecord(SignInRecord signInRecord) {
        signInMapper.insertSelective(signInRecord);
    }

    @Override
    public void updateRecord(SignInRecord signInRecord) {
        signInMapper.updateByPrimaryKeySelective(signInRecord);
    }

    @Override
    public SignInRecord signIn(Long userId, Date nowDate, boolean isContinuous, boolean toSign) {
        SignInRecord signInRecord = signInMapper.selectOne(new SignInRecord(userId, DateUtils.getMonth()));
        int milliseconds = (int) (nowDate.getTime() - DateUtils.truncate(nowDate, Calendar.DATE).getTime());
        int day = (int) DateUtils.getFragmentInDays(nowDate, Calendar.MONTH);
        if(null == signInRecord){
            signInRecord = new SignInRecord();
            signInRecord.setContinuousCounts(1);
            signInRecord.setCounts(1);
            signInRecord.setMilliseconds(milliseconds);
            signInRecord.setMonth(DateUtils.getMonth());
            signInRecord.setRecordBits(setOne(SignInController.ZERO31, day));
            signInRecord.setUserId(userId);
            signInMapper.insertSelective(signInRecord);
        }else if(toSign){
            signInRecord.setContinuousCounts(isContinuous ? signInRecord.getContinuousCounts() + 1 : 1);
            signInRecord.setCounts(signInRecord.getCounts() + 1);
            signInRecord.setMilliseconds(signInRecord.getMilliseconds() + milliseconds);
            signInRecord.setRecordBits(setOne(signInRecord.getRecordBits(), day));
            signInMapper.updateByPrimaryKeySelective(signInRecord);
        }
        return signInRecord;
    }

    @Override
    public List<Signer> selectList(String month) {
        return signInMapper.selectList(month);
    }

    @Override
    public List<SignInRank> getRanks(User user){
        //获得排行榜
        List<SignInRank> signInRanks = signInMapper.selectSignInRank(DateUtils.getMonth());
        SignInRank iter;
        SignInRank myRank = null;
        int lastIndex = signInRanks.size() - 1;
        int endIndex = lastIndex;
        int i = 0;
        for (; i <= Math.min(lastIndex, endIndex); i++) {
            iter = signInRanks.get(i);
            iter.setRank(i+1);
            if(user.getUserId().equals(iter.getUserId())){
                myRank = iter;
                if(myRank.getRank() <= 12){
                    // 取前20名
                    endIndex = 20;
                }else{
                    // 再取我后面7人排名
                    endIndex = i+7;
                }
            }
        }
        signInRanks = signInRanks.subList(0, i);
        List<SignInRank> resultRanks;
        if(myRank != null){
            if(myRank.getRank() <= 12){
                resultRanks = signInRanks;
            }else{
                resultRanks = signInRanks.subList(0, 5);
                resultRanks.addAll(signInRanks.subList(myRank.getRank()-8, signInRanks.size()));
            }
        }else{
            myRank = new SignInRank(0, user.getNickName(), user.getAvatar(), 0, 0, user.getUserId());
            if(signInRanks.size() <= 12){
                resultRanks = signInRanks;
            }else{
                resultRanks = signInRanks.subList(0, 5);
                resultRanks.addAll(signInRanks.subList(signInRanks.size()-7, signInRanks.size()));
            }
        }
        resultRanks.add(myRank);
        return resultRanks;
    }

    private String setOne(String str, int day){
        return StringUtils.overlay(str, "1", day-1, day);
    }
}
