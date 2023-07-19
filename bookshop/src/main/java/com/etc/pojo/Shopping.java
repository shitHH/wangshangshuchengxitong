package com.etc.pojo;

/**
 * @author zwh
 * @date 2021/11/17
 * 购物车类
 */
public class Shopping {

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

    public Shopping() {
    }

    public Shopping(int shoppingId, int userId, int commodityId, int commodityNumber) {
        this.shoppingId = shoppingId;
        this.userId = userId;
        this.commodityId = commodityId;
        this.commodityNumber = commodityNumber;
    }

    @Override
    public String toString() {
        return "Shopping{" +
                "shoppingId=" + shoppingId +
                ", userId=" + userId +
                ", commodityId=" + commodityId +
                ", commodityNumber=" + commodityNumber +
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
}
