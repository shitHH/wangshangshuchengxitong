package com.etc.vo;

import com.etc.pojo.User;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.sql.Timestamp;

public class BlogsVO {
    /**
     * 博客编号
     */
    private int blogsId;

    /**
     * 博客名称
     */
    private String blogsTitle;

    /**
     * 博客摘要
     */
    private String blogsSummary;

    /**
     * 博客内容
     */
    private String blogsText;

    /**
     * 创建者编号
     */
    private int userId;
    /**
     * 用户名
     */
    private String userName;
    /**
     * 头像链接地址
     */
    private String userPhoto;

    /**
     * 创建时间
     */
    private Timestamp blogsCtime;

    /**
     * 博客当前热度
     */
    private int bolgsHeat;


    public BlogsVO() {
    }

    public BlogsVO(int blogsId, String blogsTitle, String blogsSummary, String blogsText, int userId, String userName, String userPhoto, Timestamp blogsCtime, int bolgsHeat) {
        this.blogsId = blogsId;
        this.blogsTitle = blogsTitle;
        this.blogsSummary = blogsSummary;
        this.blogsText = blogsText;
        this.userId = userId;
        this.userName = userName;
        this.userPhoto = userPhoto;
        this.blogsCtime = blogsCtime;
        this.bolgsHeat = bolgsHeat;
    }

    @Override
    public String toString() {
        return "BlogsVO{" +
                "blogsId=" + blogsId +
                ", blogsTitle='" + blogsTitle + '\'' +
                ", blogsSummary='" + blogsSummary + '\'' +
                ", blogsText='" + blogsText + '\'' +
                ", userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userPhoto='" + userPhoto + '\'' +
                ", blogsCtime=" + blogsCtime +
                ", bolgsHeat=" + bolgsHeat +
                '}';
    }

    public int getBlogsId() {
        return blogsId;
    }

    public void setBlogsId(int blogsId) {
        this.blogsId = blogsId;
    }

    public String getBlogsTitle() {
        return blogsTitle;
    }

    public void setBlogsTitle(String blogsTitle) {
        this.blogsTitle = blogsTitle;
    }

    public String getBlogsSummary() {
        return blogsSummary;
    }

    public void setBlogsSummary(String blogsSummary) {
        this.blogsSummary = blogsSummary;
    }

    public String getBlogsText() {
        return blogsText;
    }

    public void setBlogsText(String blogsText) {
        this.blogsText = blogsText;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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

    public Timestamp getBlogsCtime() {
        return blogsCtime;
    }

    public void setBlogsCtime(Timestamp blogsCtime) {
        this.blogsCtime = blogsCtime;
    }

    public int getBolgsHeat() {
        return bolgsHeat;
    }

    public void setBolgsHeat(int bolgsHeat) {
        this.bolgsHeat = bolgsHeat;
    }
}
