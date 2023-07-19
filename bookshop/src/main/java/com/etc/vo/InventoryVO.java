package com.etc.vo;

/**
 * @author zwh
 * @date 2021/11/17
 * 库存类VO
 */
public class InventoryVO {
    /**
     * 库存编号
     */
    private int inventoryId;

    /**
     * 商品编号
     */
    private int commodityId;

    /**
     * 库存余量
     */
    private int inventoryNumber;

    /**
     * 商品名称
     */
    private String commodityName;

    public InventoryVO() {
    }

    public InventoryVO(int inventoryId, int commodityId, int inventoryNumber, String commodityName) {
        this.inventoryId = inventoryId;
        this.commodityId = commodityId;
        this.inventoryNumber = inventoryNumber;
        this.commodityName = commodityName;
    }

    @Override
    public String toString() {
        return "InventoryIdVO{" +
                "inventoryId=" + inventoryId +
                ", commodityId=" + commodityId +
                ", inventoryNumber=" + inventoryNumber +
                ", commodityName='" + commodityName + '\'' +
                '}';
    }

    public int getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(int inventoryId) {
        this.inventoryId = inventoryId;
    }

    public int getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(int commodityId) {
        this.commodityId = commodityId;
    }

    public int getInventoryNumber() {
        return inventoryNumber;
    }

    public void setInventoryNumber(int inventoryNumber) {
        this.inventoryNumber = inventoryNumber;
    }

    public String getCommodityName() {
        return commodityName;
    }

    public void setCommodityName(String commodityName) {
        this.commodityName = commodityName;
    }
}
