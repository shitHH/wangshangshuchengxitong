package com.etc.vo;

import java.sql.Timestamp;

/**
 * @author zwh
 * @date 2021/11/17
 * 评论类视图
 */
public class CommentVO {

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

    /**
     * 评论人姓名
     */
    private String userName;

    /**
     * 评论人头像
     */
    private String userPhoto;

    public CommentVO() {
    }

    public CommentVO(int commentId, int commentType, int fkid, int cparentId, int userId, String commentText, Timestamp commentCtime, String userName, String userPhoto) {
        this.commentId = commentId;
        this.commentType = commentType;
        this.fkid = fkid;
        this.cparentId = cparentId;
        this.userId = userId;
        this.commentText = commentText;
        this.commentCtime = commentCtime;
        this.userName = userName;
        this.userPhoto = userPhoto;
    }

    @Override
    public String toString() {
        return "CommentVO{" +
                "commentId=" + commentId +
                ", commentType=" + commentType +
                ", fkid=" + fkid +
                ", cparentId=" + cparentId +
                ", userId=" + userId +
                ", commentText='" + commentText + '\'' +
                ", commentCtime=" + commentCtime +
                ", userName='" + userName + '\'' +
                ", userPhoto='" + userPhoto + '\'' +
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPhoto() {
        return userPhoto;
    }

    public void setUserPhoto(String userPhoto) {
        this.userPhoto = userPhoto;
    }
}