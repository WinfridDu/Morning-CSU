package com.csuylg.modules.system.service.impl;

import com.csuylg.modules.system.domain.Notice;
import com.csuylg.modules.system.mapper.NoticeMapper;
import com.csuylg.modules.system.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 通知公告接口业务实现类
 *
 * @author dyf
 */
@Service
public class NoticeServiceImpl implements NoticeService {
    @Autowired
    private NoticeMapper noticeMapper;

    @Override
    public List<String> selectNoticeList(){
        return noticeMapper.selectTitleList();
    }

    @Override
    public String selectContentByTitle(String title) {
        return noticeMapper.selectContentByTitle(title);
    }

    @Override
    public int insertNotice(Notice notice) {
        Notice temp = noticeMapper.selectOne(new Notice(notice.getNoticeTitle()));
        if (null == temp) {
            noticeMapper.insertSelective(notice);
            return notice.getNoticeId();
        }else{
            return temp.getNoticeId();
        }
    }

    @Override
    public void deleteNoticeByTitle(String title) {
        noticeMapper.deleteNoticeByTitle(title);
    }

    @Override
    public List<String> selectImgListByTitle(String title) {
        return noticeMapper.selectImgListByTitle(title);
    }
}
