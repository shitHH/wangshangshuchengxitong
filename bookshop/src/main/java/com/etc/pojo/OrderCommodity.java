package com.etc.pojo;

/**
 * @author zwh
 * @date 2021/11/17
 * 订单详情类
 */
public class OrderCommodity {

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

    public OrderCommodity() {
    }

    public OrderCommodity(int orderCommodityId, int orderFormId, int commodityId, int orderCommodityNumber) {
        this.orderCommodityId = orderCommodityId;
        this.orderFormId = orderFormId;
        this.commodityId = commodityId;
        this.orderCommodityNumber = orderCommodityNumber;
    }

    @Override
    public String toString() {
        return "OrderCommodity{" +
                "orderCommodityId=" + orderCommodityId +
                ", orderFormId=" + orderFormId +
                ", commodityId=" + commodityId +
                ", orderCommodityNumber=" + orderCommodityNumber +
                '}';
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
}
