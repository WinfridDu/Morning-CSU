package com.csuylg.modules.media.controller;

import com.csuylg.common.web.CommonResponse;
import com.csuylg.modules.media.domain.Comment;
import com.csuylg.modules.media.dto.UserComment;
import com.csuylg.modules.media.service.CommentService;
import com.csuylg.modules.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Date;
import java.util.List;

/**
 * 评论信息操作处理
 *
 * @author dyf
 */
@RestController
public class CommentController{

    @Autowired
    private CommentService commentService;

    @Autowired
    private UserService userService;

    /**
     * 发布评论
     */
    @PostMapping("/CommentServlet")
    public void add(Long mediaId, String openid, String nickName, String avatarUrl, String content){
        Long userId = userService.updateUserByOpenid(openid, nickName, avatarUrl);
        Comment comment = new Comment();
        comment.setContent(encode(content));
        comment.setCreateTime(new Date());
        comment.setMediaId(mediaId);
        comment.setUserId(userId);
        commentService.insertComment(comment);
    }

    /**
     * 删除评论
     */
    @DeleteMapping("/CommentServlet")
    public CommonResponse remove(@RequestParam("comment_id") Long commentId){
        if(commentService.deleteById(commentId) > 0){
            return CommonResponse.success();
        }else{
            return CommonResponse.fail();
        }
    }

    /**
     * 查询评论列表
     */
    @GetMapping("/ComSrcServlet")
    public List<UserComment> list(Long mediaId) {
        List<UserComment> comments = commentService.selectListByMediaId(mediaId);
        for (UserComment comment : comments) {
            comment.setContent(decode(comment.getContent()));
        }
        return comments;
    }

    /**
     * 因为服务器数据库版本过低，不支持utf8mb4存储emoji表情，所以只能采用编码方式存储
     */
    private String encode(String originalString){
        return Base64.getEncoder().encodeToString(originalString.getBytes(StandardCharsets.UTF_8));
    }

    private String decode(String encodedString){
        byte[] decodedBytes = Base64.getDecoder().decode(encodedString);
        return new String(decodedBytes, StandardCharsets.UTF_8);
    }
}
