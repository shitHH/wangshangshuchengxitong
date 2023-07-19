package com.etc.pojo;

/**
 * @author zwh
 * @date 2021/11/17
 * 会员卡类型类
 */
public class Mtype {
    /**
     * 会员类型编号
     */
    private int mtypeId;

    /**
     * 会员卡类型名称
     */
    private String mtypeName;

    /**
     * 会员卡 押金
     */
    private double mtypePrice;

    /**
     * 会员卡有效时间
     */
    private int mtypetime;

    public Mtype() {
    }

    public Mtype(int mtypeId, String mtypeName, double mtypePrice, int mtypetime) {
        this.mtypeId = mtypeId;
        this.mtypeName = mtypeName;
        this.mtypePrice = mtypePrice;
        this.mtypetime = mtypetime;
    }

    @Override
    public String toString() {
        return "Mtype{" +
                "mtypeId=" + mtypeId +
                ", mtypeName='" + mtypeName + '\'' +
                ", mtypePrice=" + mtypePrice +
                ", mtypetime=" + mtypetime +
                '}';
    }

    public int getMtypeId() {
        return mtypeId;
    }

    public void setMtypeId(int mtypeId) {
        this.mtypeId = mtypeId;
    }

    public String getMtypeName() {
        return mtypeName;
    }

    public void setMtypeName(String mtypeName) {
        this.mtypeName = mtypeName;
    }

    public double getMtypePrice() {
        return mtypePrice;
    }

    public void setMtypePrice(double mtypePrice) {
        this.mtypePrice = mtypePrice;
    }

    public int getMtypetime() {
        return mtypetime;
    }

    public void setMtypetime(int mtypetime) {
        this.mtypetime = mtypetime;
    }
}
