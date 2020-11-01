package com.csuylg.modules.media.service;

import com.csuylg.modules.media.domain.MediaFile;
import com.csuylg.modules.media.dto.MediaResponse;

import java.util.List;

/**
 * 媒体文件业务层接口
 *
 * @author dyf
 */
public interface MediaFileService {
    /**
     * 新增媒体文件
     * @param mediaFile 媒体文件
     */
    void insertMediaFile(MediaFile mediaFile);

    /**
     * 更新
     * @param mediaFile 媒体文件
     */
    void updateMediaFile(MediaFile mediaFile);

    /**
     * 查询媒体文件列表
     * @param mediaFile 媒体文件查询信息
     * @return 媒体文件列表
     */
    List<MediaResponse> selectMediaList(MediaFile mediaFile);

    /**
     * 查询音视频介绍文本
     * @param mediaId 文件id
     * @return 介绍文本
     */
    String selectIntroById(Long mediaId);

    /**
     * 删除音视频文件数据
     * @param mediaId 文件id
     */
    void deleteMediaFileById(Long mediaId);
}
