package com.csuylg.modules.media.service.impl;

import com.csuylg.modules.media.domain.MediaFile;
import com.csuylg.modules.media.dto.MediaResponse;
import com.csuylg.modules.media.mapper.MediaFileMapper;
import com.csuylg.modules.media.service.MediaFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 媒体文件业务层接口实现类
 *
 * @author dyf
 */
@Service
public class MediaFileServiceImpl implements MediaFileService {
    @Autowired
    private MediaFileMapper mediaFileMapper;

    @Override
    public void insertMediaFile(MediaFile mediaFile) {
        mediaFileMapper.insertSelective(mediaFile);
    }

    @Override
    public void updateMediaFile(MediaFile mediaFile) {
        mediaFileMapper.updateByPrimaryKeySelective(mediaFile);
    }

    @Override
    public List<MediaResponse> selectMediaList(MediaFile mediaFile) {
        return mediaFileMapper.selectMediaList(mediaFile);
    }

    @Override
    public String selectIntroById(Long mediaId) {
        return mediaFileMapper.selectIntroById(mediaId);
    }

    @Override
    public void deleteMediaFileById(Long mediaId) {
        mediaFileMapper.deleteByPrimaryKey(mediaId);
    }
}
