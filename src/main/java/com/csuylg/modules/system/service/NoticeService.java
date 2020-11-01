package com.csuylg.modules.system.service;

import com.csuylg.modules.system.domain.Notice;

import java.util.List;

/**
 * 通知公告业务层接口
 *
 * @author dyf
 */
public interface NoticeService {
    /**
     * 查询标题列表
     * @return 标题列表
     */
    List<String> selectNoticeList();

    /**
     * 根据标题查找通知内容
     * @param title 通知标题
     * @return 通知内容
     */
    String selectContentByTitle(String title);

    /**
     * 新增通知
     *
     * @param notice 通知信息
     * @return 结果
     */
    int insertNotice(Notice notice);

    /**
     * 根据标题删除通知
     * @param title 通知标题
     */
    void deleteNoticeByTitle(String title);

    /**
     * 查询通知图片url
     * @param title 通知标题
     * @return 图片url列表
     */
    List<String> selectImgListByTitle(String title);
}
