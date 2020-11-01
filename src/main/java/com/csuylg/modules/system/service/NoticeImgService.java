package com.csuylg.modules.system.service;

import com.csuylg.modules.system.domain.NoticeImg;

/**
 * 通知图片业务层接口
 *
 * @author dyf
 */
public interface NoticeImgService {
    /**
     * 新增通知图片
     * @param noticeImg 通知图片
     */
    void insertNoticeImg(NoticeImg noticeImg);
}
