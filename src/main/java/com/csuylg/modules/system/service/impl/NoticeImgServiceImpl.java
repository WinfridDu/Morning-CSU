package com.csuylg.modules.system.service.impl;

import com.csuylg.modules.system.domain.NoticeImg;
import com.csuylg.modules.system.mapper.NoticeImgMapper;
import com.csuylg.modules.system.service.NoticeImgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 通知图片业务层接口实现类
 *
 * @author dyf
 */
@Service
public class NoticeImgServiceImpl implements NoticeImgService {
    @Autowired
    private NoticeImgMapper noticeImgMapper;

    @Override
    public void insertNoticeImg(NoticeImg noticeImg) {
        noticeImgMapper.insertSelective(noticeImg);
    }
}
