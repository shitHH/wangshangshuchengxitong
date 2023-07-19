package com.etc.pojo;

/**
 * @author zwh
 * @date 2021/11/17
 * 库存类
 */
public class Inventory {

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

    public Inventory() {
    }

    public Inventory(int inventoryId, int commodityId, int inventoryNumber) {
        this.inventoryId = inventoryId;
        this.commodityId = commodityId;
        this.inventoryNumber = inventoryNumber;
    }

    @Override
    public String toString() {
        return "Inventory{" +
                "inventoryId=" + inventoryId +
                ", commodityId=" + commodityId +
                ", inventoryNumber=" + inventoryNumber +
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
}
