package com.csuylg.modules.media.mapper;

import com.csuylg.modules.media.domain.MediaFile;
import com.csuylg.modules.media.dto.MediaResponse;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * 媒体文件表的Dao
 *
 * @author dyf
 */
public interface MediaFileMapper extends Mapper<MediaFile> {
    /**
     * 更新状态
     * @param title 标题
     * @param status 状态
     */
    @Update("update media_file set status = #{status} where media_title = #{title}")
    void updateStatusByTitle(String title, String status);

    /**
     * 查看媒体文件列表
     * @param mediaFile 媒体文件
     * @return 媒体文件列表
     */
    List<MediaResponse> selectMediaList(MediaFile mediaFile);

    /**
     * 查询音视频介绍文本
     * @param mediaId 文件id
     * @return 介绍文本
     */
    @Select("select introduction from media_file where media_id = #{mediaId}")
    String selectIntroById(Long mediaId);
}
