package com.csuylg.modules.media.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.sql.Timestamp;

/**
 * 用户评论类
 *
 * @author dyf
 */
public class UserComment {
    private Long commentId;

    private String content;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Timestamp date;

    private String nickName;

    private String avatarUrl;

    public UserComment(Long commentId, String content, Timestamp date, String nickName, String avatarUrl) {
        this.commentId = commentId;
        this.content = content;
        this.date = date;
        this.nickName = nickName;
        this.avatarUrl = avatarUrl;
    }

    public Long getCommentId() { return commentId; }

    public void setCommentId (Long commentId){ this.commentId = commentId; }

    public String getContent() { return content; }

    public void setContent(String content) { this.content = content; }

    public String getNickName() { return nickName; }

    public void setNickName(String nickName) { this.nickName = nickName; }

    public String getAvatarUrl() { return avatarUrl; }

    public void setAvatarUrl(String avatarUrl) { this.avatarUrl = avatarUrl; }

    public Timestamp getDate() { return date; }

    public void setDate(Timestamp date) { this.date = date; }
}
