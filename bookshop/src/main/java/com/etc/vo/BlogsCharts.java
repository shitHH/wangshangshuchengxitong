package com.etc.vo;

/**
 * @author zwh
 * @date 2021/11/19
 * 博客图表信息VO
 */
public class BlogsCharts {
    private int userId;
    /**
     * 人员名称
     */
    private String name;

    /**
     * 个人发帖数量
     */
    private String value;

    /**
     * 帖子总热度
     */
    private String heats;

    public BlogsCharts(int userId, String name, String value, String heats) {
        this.userId = userId;
        this.name = name;
        this.value = value;
        this.heats = heats;
    }

    @Override
    public String toString() {
        return "BlogsCharts{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", value='" + value + '\'' +
                ", heats='" + heats + '\'' +
                '}';
    }

    public BlogsCharts() {
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getHeats() {
        return heats;
    }

    public void setHeats(String heats) {
        this.heats = heats;
    }
}
