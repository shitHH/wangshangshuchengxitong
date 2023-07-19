package com.etc.pojo;

import java.sql.Timestamp;

/**
 * @author zwh
 * @date 2021/11/17
 * 说说类
 */
public class Blogs {

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
     * 创建时间
     */
    private Timestamp blogsCtime;

    public Blogs() {
    }

    public Blogs(int blogsId, String blogsTitle, String blogsSummary, String blogsText, int userId, Timestamp blogsCtime) {
        this.blogsId = blogsId;
        this.blogsTitle = blogsTitle;
        this.blogsSummary = blogsSummary;
        this.blogsText = blogsText;
        this.userId = userId;
        this.blogsCtime = blogsCtime;
    }

    @Override
    public String toString() {
        return "Blogs{" +
                "blogsId=" + blogsId +
                ", blogsTitle='" + blogsTitle + '\'' +
                ", blogsSummary='" + blogsSummary + '\'' +
                ", blogsText='" + blogsText + '\'' +
                ", userId=" + userId +
                ", blogsCtime=" + blogsCtime +
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

    public Timestamp getBlogsCtime() {
        return blogsCtime;
    }

    public void setBlogsCtime(Timestamp blogsCtime) {
        this.blogsCtime = blogsCtime;
    }
}
