package com.etc.pojo;

/**
 * @author zwh
 * @date 2021/11/17
 * 分类表
 */
public class Sort {

    /**
     * 类目id
     */
    private int sortId;

    /**
     * 类目种类1：书籍、2：商品
     */
    private int sortType;

    /**
     * 类目名称
     */
    private String sortName;

    /**
     * 父类目id，0时为根目录
     */
    private int parentId;

    /**
     * 是否启用0弃用1启用
     */
    private int sortStats;

    /**
     * 排序指数，越小越靠前
     */
    private int sortOrder;

    public Sort() {
    }

    public Sort(int sortId, int sortType, String sortName, int parentId, int sortStats, int sortOrder) {
        this.sortId = sortId;
        this.sortType = sortType;
        this.sortName = sortName;
        this.parentId = parentId;
        this.sortStats = sortStats;
        this.sortOrder = sortOrder;
    }

    @Override
    public String toString() {
        return "Sort{" +
                "sortId=" + sortId +
                ", sortType=" + sortType +
                ", sortName='" + sortName + '\'' +
                ", parentId=" + parentId +
                ", sortStats=" + sortStats +
                ", sortOrder=" + sortOrder +
                '}';
    }

    public int getSortId() {
        return sortId;
    }

    public void setSortId(int sortId) {
        this.sortId = sortId;
    }

    public int getSortType() {
        return sortType;
    }

    public void setSortType(int sortType) {
        this.sortType = sortType;
    }

    public String getSortName() {
        return sortName;
    }

    public void setSortName(String sortName) {
        this.sortName = sortName;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public int getSortStats() {
        return sortStats;
    }

    public void setSortStats(int sortStats) {
        this.sortStats = sortStats;
    }

    public int getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(int sortOrder) {
        this.sortOrder = sortOrder;
    }
}
