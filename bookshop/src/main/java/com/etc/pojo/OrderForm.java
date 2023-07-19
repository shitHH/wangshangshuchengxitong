package com.etc.pojo;

import java.sql.Timestamp;

/**
 * @author zwh
 * @date 2021/11/17
 * 订单类
 */
public class OrderForm {
    /**
     * 订单编号
     */
    private int orderFormId;

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

    public OrderForm() {
    }

    public OrderForm(int orderFormId, int formStatsId, double orderPrice, int userId, String clientSite, Timestamp orderFormDate, String orderFormNote) {
        this.orderFormId = orderFormId;
        this.formStatsId = formStatsId;
        this.orderPrice = orderPrice;
        this.userId = userId;
        this.clientSite = clientSite;
        this.orderFormDate = orderFormDate;
        this.orderFormNote = orderFormNote;
    }

    @Override
    public String toString() {
        return "OrderForm{" +
                "orderFormId=" + orderFormId +
                ", formStatsId=" + formStatsId +
                ", orderPrice=" + orderPrice +
                ", userId=" + userId +
                ", clientSite='" + clientSite + '\'' +
                ", orderFormDate=" + orderFormDate +
                ", orderFormNote='" + orderFormNote + '\'' +
                '}';
    }

    public int getOrderFormId() {
        return orderFormId;
    }

    public void setOrderFormId(int orderFormId) {
        this.orderFormId = orderFormId;
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
}
