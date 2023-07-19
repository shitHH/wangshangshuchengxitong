package com.etc.pojo;

import java.sql.Timestamp;

/**
 * @author zwh
 * @date 2021/11/17
 * 评论类
 */
public class Comment {

    /**
     * 评论编号
     */
    private int commentId;

    /**
     * 评论类型：1：书籍 2：商品  3：博客
     */
    private int commentType;

    /**
     * 关联表编号
     */
    private int fkid;

    /**
     * 父节点：根目录为0
     */
    private int cparentId;

    /**
     * 人员编号
     */
    private int userId;

    /**
     * 评论内容
     */
    private String commentText;

    /**
     * 评论时间
     */
    private Timestamp commentCtime;

    public Comment() {
    }

    public Comment(int commentId, int commentType, int fkid, int cparentId, int userId, String commentText, Timestamp commentCtime) {
        this.commentId = commentId;
        this.commentType = commentType;
        this.fkid = fkid;
        this.cparentId = cparentId;
        this.userId = userId;
        this.commentText = commentText;
        this.commentCtime = commentCtime;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "commentId=" + commentId +
                ", commentType=" + commentType +
                ", fkid=" + fkid +
                ", cparentId=" + cparentId +
                ", userId=" + userId +
                ", commentText='" + commentText + '\'' +
                ", commentCtime=" + commentCtime +
                '}';
    }

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public int getCommentType() {
        return commentType;
    }

    public void setCommentType(int commentType) {
        this.commentType = commentType;
    }

    public int getFkid() {
        return fkid;
    }

    public void setFkid(int fkid) {
        this.fkid = fkid;
    }

    public int getCparentId() {
        return cparentId;
    }

    public void setCparentId(int cparentId) {
        this.cparentId = cparentId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }

    public Timestamp getCommentCtime() {
        return commentCtime;
    }

    public void setCommentCtime(Timestamp commentCtime) {
        this.commentCtime = commentCtime;
    }
}
