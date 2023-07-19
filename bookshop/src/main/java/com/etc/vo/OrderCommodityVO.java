package com.etc.vo;

import java.sql.Timestamp;

/**
 * @version v1.0
 * @Author: Slark
 * @Date: Created in2021/11/18  15:46
 */
public class OrderCommodityVO {
    /**
     * 订单、商品关系编号
     */
    private int orderCommodityId;

    /**
     * 订单编号
     */
    private int orderFormId;

    /**
     * 商品编号
     */
    private int commodityId;

    /**
     * 商品数量
     */
    private int orderCommodityNumber;

    /**
     * 单据状态0：未支付1：支付
     */
    private int formStatsId;

    /**
     * 支付金额
     */
    private double orderPrice;

    /**
     * 顾客编号
     */
    private int userId;

    /**
     * 收货地址
     */
    private String clientSite;

    /**
     * 订单日期
     */
    private Timestamp orderFormDate;

    /**
     * 备注
     */
    private String orderFormNote;

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

    public OrderCommodityVO() {
    }

    public OrderCommodityVO(int orderCommodityId, int orderFormId, int commodityId, int orderCommodityNumber, int formStatsId, double orderPrice, int userId, String clientSite, Timestamp orderFormDate, String orderFormNote, String commodityName, int sortIdOne, int sortIdTwo, int sortIdThree, String commodityBrand, double commodityPrice, String commodityBrief, String commodityPicture, int companyStats) {
        this.orderCommodityId = orderCommodityId;
        this.orderFormId = orderFormId;
        this.commodityId = commodityId;
        this.orderCommodityNumber = orderCommodityNumber;
        this.formStatsId = formStatsId;
        this.orderPrice = orderPrice;
        this.userId = userId;
        this.clientSite = clientSite;
        this.orderFormDate = orderFormDate;
        this.orderFormNote = orderFormNote;
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

    public int getOrderCommodityId() {
        return orderCommodityId;
    }

    public void setOrderCommodityId(int orderCommodityId) {
        this.orderCommodityId = orderCommodityId;
    }

    public int getOrderFormId() {
        return orderFormId;
    }

    public void setOrderFormId(int orderFormId) {
        this.orderFormId = orderFormId;
    }

    public int getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(int commodityId) {
        this.commodityId = commodityId;
    }

    public int getOrderCommodityNumber() {
        return orderCommodityNumber;
    }

    public void setOrderCommodityNumber(int orderCommodityNumber) {
        this.orderCommodityNumber = orderCommodityNumber;
    }

    public int getFormStatsId() {
        return formStatsId;
    }

    public void setFormStatsId(int formStatsId) {
        this.formStatsId = formStatsId;
    }

    public double getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(double orderPrice) {
        this.orderPrice = orderPrice;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getClientSite() {
        return clientSite;
    }

    public void setClientSite(String clientSite) {
        this.clientSite = clientSite;
    }

    public Timestamp getOrderFormDate() {
        return orderFormDate;
    }

    public void setOrderFormDate(Timestamp orderFormDate) {
        this.orderFormDate = orderFormDate;
    }

    public String getOrderFormNote() {
        return orderFormNote;
    }

    public void setOrderFormNote(String orderFormNote) {
        this.orderFormNote = orderFormNote;
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
