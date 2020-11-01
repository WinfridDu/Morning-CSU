package com.csuylg.modules.signin.controller;

import com.csuylg.common.utils.DateUtils;
import com.csuylg.common.utils.ExcelUtil;
import com.csuylg.common.utils.StringUtils;
import com.csuylg.modules.media.domain.MediaFile;
import com.csuylg.modules.media.dto.MediaResponse;
import com.csuylg.modules.media.service.MediaFileService;
import com.csuylg.modules.signin.domain.SignInRank;
import com.csuylg.modules.signin.domain.SignInRecord;
import com.csuylg.modules.signin.dto.BadgeInfo;
import com.csuylg.modules.signin.dto.SignInResponse;
import com.csuylg.modules.signin.dto.Signer;
import com.csuylg.modules.signin.service.BadgeService;
import com.csuylg.modules.signin.service.SignInService;
import com.csuylg.modules.system.domain.User;
import com.csuylg.modules.system.service.UserService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 签到相关控制层
 *
 * @author dyf
 */
@RestController
public class SignInController {
    public static final String ZERO31 = "0000000000000000000000000000000";

    private static final int BEGIN_MINUTE_OF_DAY = 6 * 60 + 30;
    private static final int END_MINUTE_OF_DAY = 8 * 60;

    @Autowired
    private SignInService signInService;

    @Autowired
    private UserService userService;

    @Autowired
    private BadgeService badgeService;

    @Autowired
    private MediaFileService mediaFileService;

    /**
     * 响应用户点击签到按钮发送的请求
     */
    @GetMapping("/Sign_inServlet")
    @Transactional(rollbackFor = Exception.class)
    public SignInResponse signIn(String openid, String nickName, String avatarUrl){
        if(StringUtils.isEmpty(openid)){
            return null;
        }
        SignInResponse signInResponse = null;
        User user = userService.selectUser(new User(openid));
        if(user != null){
            // 判断是否在签到时间范围内
            Date nowDate = new Date();
            if(!DateUtils.isBetweenTime(nowDate, BEGIN_MINUTE_OF_DAY, END_MINUTE_OF_DAY)){
                return new SignInResponse(0, 0);
            }

            signInResponse = new SignInResponse();
            // 不是同一天，说明当天未签到
            boolean toSign = !DateUtils.isSameDay(nowDate, user.getLastSignInDate());
            // 判断是否连续签到
            boolean isContinuous = DateUtils.isNextDay(nowDate, user.getLastSignInDate());
            if(toSign){
                // 更新用户数据、总签到数据
                user.setAvatar(avatarUrl);
                user.setLastSignInDate(nowDate);
                user.setNickName(nickName);
                user.setTotalContinuousCounts(isContinuous ? user.getTotalContinuousCounts() + 1 : 1);
                user.setTotalCounts(user.getTotalCounts() + 1);
                userService.updateUser(user);
            }
             //更新用户当月签到数据
            SignInRecord signInRecord = signInService.signIn(user.getUserId(), nowDate, isContinuous, toSign);
            signInResponse.setCounts(signInRecord.getContinuousCounts());
            signInResponse.setDetailDates(signInRecord.getRecordBits());

            // 更新徽章数据
            BadgeInfo badgeInfo;
            if(toSign){
                badgeInfo = badgeService.updateBadge(user.getTotalContinuousCounts(), signInRecord.getContinuousCounts(), user.getUserId());
            }else{
                badgeInfo = new BadgeInfo(false, false);
            }
            signInResponse.setBadgeInfo(badgeInfo);

            // 获取排行榜
            List<SignInRank> ranks = signInService.getRanks(user);
            signInResponse.setUserRank(ranks.remove(ranks.size()-1));
            signInResponse.setList(ranks);

            // 获取音频
            MediaResponse mediaResponse = null;
            PageHelper.startPage(1, 1);
            List<MediaResponse> mediaList = mediaFileService.selectMediaList(new MediaFile("sound", "1"));
            if(StringUtils.isNotEmpty(mediaList)){
                mediaResponse = mediaList.get(0);
            }
            signInResponse.setLatestSound(mediaResponse);
            System.out.println(mediaResponse);

            //获取当前签到人数
            signInResponse.setSignedNum(userService.selectSignCount());
        }
        return signInResponse;
    }

    @GetMapping("/SignerList")
    public List<Signer> list(String month, Integer pageNum, Integer pageSize){
        PageHelper.startPage(pageNum, pageSize);
        return signInService.selectList(month);
    }

    @GetMapping("/export")
    public Map<String, Object> export(String month) throws Exception {
        List<Signer> signers = signInService.selectList(month);
        ExcelUtil<Signer> util = new ExcelUtil<>(Signer.class);
        return util.exportExcel(signers, month+"签到数据");
    }
}
