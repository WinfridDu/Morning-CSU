package com.csuylg.modules.media.mapper;

import com.csuylg.modules.media.domain.Comment;
import com.csuylg.modules.media.dto.UserComment;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * 的Dao
 *
 * @author dyf
 */
public interface CommentMapper extends Mapper<Comment> {
    /**
     * 根据媒体文件id查询评论列表
     * @param mediaId 文件id
     * @return 评论列表
     */
    List<UserComment> selectList(Long mediaId);
}
