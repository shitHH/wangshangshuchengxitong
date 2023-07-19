package com.etc.vo;

/**
 * @author zwh
 * @date 2021/11/18
 * 商品类视图
 */
public class CommodityVO {
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

    /**
     * 类型1级编号名称
     */
    private String sortIdOneName;
    /**
     * 类型2级编号名称
     */
    private String sortIdTwoName;
    /**
     * 类型3级编号名称
     */
    private String sortIdThreeName;

    /**
     * 商品余量
     */
    private int inventoryNumber;

    public CommodityVO() {

    }

    public CommodityVO(int commodityId, String commodityName, int sortIdOne, int sortIdTwo, int sortIdThree, String commodityBrand, double commodityPrice, String commodityBrief, String commodityPicture, int companyStats, String sortIdOneName, String sortIdTwoName, String sortIdThreeName, int inventoryNumber) {
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
        this.sortIdOneName = sortIdOneName;
        this.sortIdTwoName = sortIdTwoName;
        this.sortIdThreeName = sortIdThreeName;
        this.inventoryNumber = inventoryNumber;
    }

    @Override
    public String toString() {
        return "CommodityVO{" +
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
                ", sortIdOneName='" + sortIdOneName + '\'' +
                ", sortIdTwoName='" + sortIdTwoName + '\'' +
                ", sortIdThreeName='" + sortIdThreeName + '\'' +
                ", inventoryNumber=" + inventoryNumber +
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

    public String getSortIdOneName() {
        return sortIdOneName;
    }

    public void setSortIdOneName(String sortIdOneName) {
        this.sortIdOneName = sortIdOneName;
    }

    public String getSortIdTwoName() {
        return sortIdTwoName;
    }

    public void setSortIdTwoName(String sortIdTwoName) {
        this.sortIdTwoName = sortIdTwoName;
    }

    public String getSortIdThreeName() {
        return sortIdThreeName;
    }

    public void setSortIdThreeName(String sortIdThreeName) {
        this.sortIdThreeName = sortIdThreeName;
    }

    public int getInventoryNumber() {
        return inventoryNumber;
    }

    public void setInventoryNumber(int inventoryNumber) {
        this.inventoryNumber = inventoryNumber;
    }
}
