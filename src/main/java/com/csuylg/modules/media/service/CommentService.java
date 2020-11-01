package com.csuylg.modules.media.service;

import com.csuylg.modules.media.domain.Comment;
import com.csuylg.modules.media.dto.UserComment;

import java.util.List;

/**
 * 业务层接口
 *
 * @author dyf
 */
public interface CommentService {
    /**
     * 新增评论
     * @param comment 评论
     */
    void insertComment(Comment comment);

    /**
     * 删除评论
     * @param commentId 评论id
     * @return 影响行数
     */
    int deleteById(Long commentId);

    /**
     * 查询评论列表
     * @param mediaId 文件id
     * @return 评论列表
     */
    List<UserComment> selectListByMediaId(Long mediaId);
}
