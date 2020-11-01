package com.csuylg.modules.media.service.impl;

import com.csuylg.modules.media.domain.Comment;
import com.csuylg.modules.media.dto.UserComment;
import com.csuylg.modules.media.mapper.CommentMapper;
import com.csuylg.modules.media.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 业务层接口实现类
 *
 * @author dyf
 */
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentMapper commentMapper;


    @Override
    public void insertComment(Comment comment) {
        commentMapper.insertSelective(comment);
    }

    @Override
    public int deleteById(Long commentId) {
        return commentMapper.deleteByPrimaryKey(commentId);
    }

    @Override
    public List<UserComment> selectListByMediaId(Long mediaId) {
        return commentMapper.selectList(mediaId);
    }
}
