package com.etc.vo;

import com.etc.pojo.Commodity;

import java.sql.Timestamp;
import java.util.List;

/**
 * @version v1.0
 * @Author: Slark
 * @Date: Created in2021/11/18  11:55
 * 订单视图
 */
public class OrderFormVO {

    /**
     * 订单编号
     */
    private int orderFormId;

    /**
     * 单据状态0：未支付1：支付
     */
    private int formStatsId;

    /**
     * 单据状态名称
     */
    private String formStatsName;
    /**
     * 支付金额
     */
    private double orderPrice;

    /**
     * 顾客编号
     */
    private int userId;

    /**
     * 顾客姓名
     */
    private String userName;

    /**
     * 顾客电话
     */
    private String userTel;

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


    private List<CommodityVO> commodityVO;

    public OrderFormVO(int orderFormId, int formStatsId, String formStatsName, double orderPrice, int userId, String userName, String userTel, String clientSite, Timestamp orderFormDate, String orderFormNote, List<CommodityVO> commodityVO) {
        this.orderFormId = orderFormId;
        this.formStatsId = formStatsId;
        this.formStatsName = formStatsName;
        this.orderPrice = orderPrice;
        this.userId = userId;
        this.userName = userName;
        this.userTel = userTel;
        this.clientSite = clientSite;
        this.orderFormDate = orderFormDate;
        this.orderFormNote = orderFormNote;
        this.commodityVO = commodityVO;
    }

    public List<CommodityVO> getCommodityVO() {
        return commodityVO;
    }

    public void setCommodityVO(List<CommodityVO> commodityVO) {
        this.commodityVO = commodityVO;
    }

    public OrderFormVO() {
    }

    public OrderFormVO(int orderFormId, int formStatsId, String formStatsName, double orderPrice, int userId, String userName, String clientSite, Timestamp orderFormDate, String orderFormNote) {
        this.orderFormId = orderFormId;
        this.formStatsId = formStatsId;
        this.formStatsName = formStatsName;
        this.orderPrice = orderPrice;
        this.userId = userId;
        this.userName = userName;
        this.clientSite = clientSite;
        this.orderFormDate = orderFormDate;
        this.orderFormNote = orderFormNote;
    }

    public OrderFormVO(int orderFormId, int formStatsId, String formStatsName, double orderPrice, int userId, String userName, String userTel, String clientSite, Timestamp orderFormDate, String orderFormNote) {
        this.orderFormId = orderFormId;
        this.formStatsId = formStatsId;
        this.formStatsName = formStatsName;
        this.orderPrice = orderPrice;
        this.userId = userId;
        this.userName = userName;
        this.userTel = userTel;
        this.clientSite = clientSite;
        this.orderFormDate = orderFormDate;
        this.orderFormNote = orderFormNote;
    }




    public String getUserTel() {
        return userTel;
    }

    public void setUserTel(String userTel) {
        this.userTel = userTel;
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

    public String getFormStatsName() {
        return formStatsName;
    }

    public void setFormStatsName(String formStatsName) {
        this.formStatsName = formStatsName;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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
