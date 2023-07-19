package com.etc.service;

import com.etc.pojo.Inventory;
import com.etc.vo.InventoryVO;

import java.util.List;
/**
 * @author zwh
 * @date 2021/11/17
 * 库存业务逻辑接口
 */
public interface InventoryService {
    /**
     * 查询全部商品库存
     * @return 库存视图对象列表
     */
    public List<InventoryVO> findAll();

    /**
     * 根据库存编号查询
     * @param inventoryId 库存编号
     * @return 库存视图对象
     */
    public InventoryVO findByInventoryId(int inventoryId);

    /**
     * 根据商品编号查询
     * @param commodityId 商品编号
     * @return 库存视图对象
     */
    public InventoryVO findByCommodityId(int commodityId);


    /**
     * 新增库存信息
     * @param inventory 库存对象
     * @return 受影响行数
     */
    public boolean add(Inventory inventory);

    /**
     * 更改库存信息
     * @param inventory 库存对象
     * @return 受影响行数
     */
    public boolean update(Inventory inventory);
}
