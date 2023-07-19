package com.etc.vo;

/**
 * @author zwh
 * @date 2021/11/17
 * 购物车视图
 */
public class ShoppingVO {
    /**
     * 购物车编号
     */
    private int shoppingId;

    /**
     * 人员编号
     */
    private int userId;

    /**
     * 商品编号
     */
    private int commodityId;

    /**
     * 购买数量
     */
    private int commodityNumber;

    /**
     * 人员姓名
     */
    private String userName;

    /**
     * 商品名称
     */
    private String commodityName;

    /**
     * 商品押金
     */
    private double commodityPrice;

    public ShoppingVO() {
    }

    public ShoppingVO(int shoppingId, int userId, int commodityId, int commodityNumber, String userName, String commodityName, double commodityPrice) {
        this.shoppingId = shoppingId;
        this.userId = userId;
        this.commodityId = commodityId;
        this.commodityNumber = commodityNumber;
        this.userName = userName;
        this.commodityName = commodityName;
        this.commodityPrice = commodityPrice;
    }

    @Override
    public String toString() {
        return "ShoppingVO{" +
                "shoppingId=" + shoppingId +
                ", userId=" + userId +
                ", commodityId=" + commodityId +
                ", commodityNumber=" + commodityNumber +
                ", userName='" + userName + '\'' +
                ", commodityName='" + commodityName + '\'' +
                ", commodityPrice=" + commodityPrice +
                '}';
    }

    public int getShoppingId() {
        return shoppingId;
    }

    public void setShoppingId(int shoppingId) {
        this.shoppingId = shoppingId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(int commodityId) {
        this.commodityId = commodityId;
    }

    public int getCommodityNumber() {
        return commodityNumber;
    }

    public void setCommodityNumber(int commodityNumber) {
        this.commodityNumber = commodityNumber;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCommodityName() {
        return commodityName;
    }

    public void setCommodityName(String commodityName) {
        this.commodityName = commodityName;
    }

    public double getCommodityPrice() {
        return commodityPrice;
    }

    public void setCommodityPrice(double commodityPrice) {
        this.commodityPrice = commodityPrice;
    }
}
