package com.etc.dao;

import com.etc.pojo.OrderCommodity;
import com.etc.vo.OrderCommodityVO;

import java.util.List;

/**
 * @version v1.0
 * @Author: Slark
 * @Date: Created in2021/11/18  15:41
 * 订单商品关系表数据访问接口
 */
public interface OrderCommodityDao {

    /**
     * 添加
     * @param orderCommodity
     * @return
     */
    public int add(OrderCommodity orderCommodity);

    /**
     * 更新
     * @param orderCommodity
     * @return
     */
    public int update(OrderCommodity orderCommodity);

    /**
     * 删除
     * @param arrays
     * @return
     */
    public int delete(int[] arrays);

    /**
     * 根据订单、商品关系编号查询
     * @param orderCommodityId
     * @return
     */
    public OrderCommodityVO findByOrderCommodityId(int orderCommodityId);

    /**
     * 根据订单编号查询
     * @param orderFormId
     * @return
     */
    public List<OrderCommodityVO> findByorderFormId(int orderFormId);

    /**
     * 根据商品编号查询
     * @param commodityId
     * @return
     */
    public List<OrderCommodityVO> findByCommodityId(int commodityId);

    /**
     * 查询所有
     * @return
     */
    public List<OrderCommodityVO> findAll();
 }
