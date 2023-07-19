package com.etc.pojo;

/**
 * @author zwh
 * @date 2021/11/17
 * 商品类
 */
public class Commodity {
    /**
     * 商品编号
     */
    private int commodityId;

    /**
     * 商品名称
     */
    private String commodityName;

    /**
     * 类型1级编号
     */
    private int sortIdOne;

    /**
     * 类型2级编号
     */
    private int sortIdTwo;

    /**
     * 类型3级编号
     */
    private int sortIdThree;

    /**
     * 品牌名称
     */
    private String commodityBrand;

    /**
     * 商品 押金
     */
    private double commodityPrice;

    /**
     * 商品简介
     */
    private String commodityBrief;

    /**
     * 商品图片链接地址
     */
    private String commodityPicture;

    /**
     * 商品状态0下架1销售
     */
    private int companyStats;

    public Commodity() {
    }

    public Commodity(int commodityId, String commodityName, int sortIdOne, int sortIdTwo, int sortIdThree, String commodityBrand, double commodityPrice, String commodityBrief, String commodityPicture, int companyStats) {
        this.commodityId = commodityId;
        this.commodityName = commodityName;
        this.sortIdOne = sortIdOne;
        this.sortIdTwo = sortIdTwo;
        this.sortIdThree = sortIdThree;
        this.commodityBrand = commodityBrand;
        this.commodityPrice = commodityPrice;
        this.commodityBrief = commodityBrief;
        this.commodityPicture = commodityPicture;
        this.companyStats = companyStats;
    }

    @Override
    public String toString() {
        return "Commodity{" +
                "commodityId=" + commodityId +
                ", commodityName='" + commodityName + '\'' +
                ", sortIdOne=" + sortIdOne +
                ", sortIdTwo=" + sortIdTwo +
                ", sortIdThree=" + sortIdThree +
                ", commodityBrand='" + commodityBrand + '\'' +
                ", commodityPrice=" + commodityPrice +
                ", commodityBrief='" + commodityBrief + '\'' +
                ", commodityPicture='" + commodityPicture + '\'' +
                ", companyStats=" + companyStats +
                '}';
    }

    public int getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(int commodityId) {
        this.commodityId = commodityId;
    }

    public String getCommodityName() {
        return commodityName;
    }

    public void setCommodityName(String commodityName) {
        this.commodityName = commodityName;
    }

    public int getSortIdOne() {
        return sortIdOne;
    }

    public void setSortIdOne(int sortIdOne) {
        this.sortIdOne = sortIdOne;
    }

    public int getSortIdTwo() {
        return sortIdTwo;
    }

    public void setSortIdTwo(int sortIdTwo) {
        this.sortIdTwo = sortIdTwo;
    }

    public int getSortIdThree() {
        return sortIdThree;
    }

    public void setSortIdThree(int sortIdThree) {
        this.sortIdThree = sortIdThree;
    }

    public String getCommodityBrand() {
        return commodityBrand;
    }

    public void setCommodityBrand(String commodityBrand) {
        this.commodityBrand = commodityBrand;
    }

    public double getCommodityPrice() {
        return commodityPrice;
    }

    public void setCommodityPrice(double commodityPrice) {
        this.commodityPrice = commodityPrice;
    }

    public String getCommodityBrief() {
        return commodityBrief;
    }

    public void setCommodityBrief(String commodityBrief) {
        this.commodityBrief = commodityBrief;
    }

    public String getCommodityPicture() {
        return commodityPicture;
    }

    public void setCommodityPicture(String commodityPicture) {
        this.commodityPicture = commodityPicture;
    }

    public int getCompanyStats() {
        return companyStats;
    }

    public void setCompanyStats(int companyStats) {
        this.companyStats = companyStats;
    }
}
