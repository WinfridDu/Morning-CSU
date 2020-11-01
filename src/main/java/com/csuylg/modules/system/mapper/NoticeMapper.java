package com.csuylg.modules.system.mapper;

import com.csuylg.modules.system.domain.Notice;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * 通知公告的Dao
 *
 * @author dyf
 */
public interface NoticeMapper extends Mapper<Notice> {
    /**
     * 查询标题列表
     * @return 标题列表
     */
    @Select("select notice_title from notice order by notice_id DESC")
    List<String> selectTitleList();

    /**
     * 查询通知内容
     * @param title 通知标题
     * @return 通知内容
     */
    @Select("select notice_content from notice where notice_title = #{title}")
    String selectContentByTitle(String title);

    /**
     * 查询通知图片列表
     * @param title 通知标题
     * @return 图片url列表
     */
    @Select("select ni.notice_img_url from notice n inner join notice_img ni on n.notice_id = ni.notice_id and n.notice_title = #{title}")
    List<String> selectImgListByTitle(String title);

    /**
     * 根据标题删除通知，连同关联图片一并删除
     * @param title 通知标题
     */
    @Delete("delete n, ni FROM notice n inner join notice_img ni on n.notice_id = ni.notice_id and n.notice_title = #{title}")
    void deleteNoticeByTitle(String title);
}
