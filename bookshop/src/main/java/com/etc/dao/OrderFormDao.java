package com.etc.dao;

import com.etc.pojo.OrderForm;
import com.etc.vo.OrderFormVO;

import java.util.List;

/**
 * @version v1.0
 * @Author: Slark
 * @Date: Created in2021/11/18  11:34
 * 订单表数据访问接口
 */
public interface OrderFormDao {


    /**
     * 添加订单
     * @param orderForm
     * @return 受影响的行数
     */
    public int add(OrderForm orderForm);

    /**
     * 更新订单
     * @param orderForm
     * @return 受影响的行数
     */
    public int update(OrderForm orderForm);

    /**
     *
     * @param orderFormId
     * @return
     */
    public int delete(int orderFormId);

    /**
     * 根据订单编号查询订单信息
     * @param orderFormId
     * @return 订单详情
     */
    public OrderForm findById(int orderFormId);

    /**
     * 根据顾客编号查询订单信息
     * @param userId
     * @return 订单详情
     */
    public List<OrderFormVO> findByUserId(int userId);

    /**
     * 根据订单状态ID查询
     * @param formStatsId
     * @return
     */
    public List<OrderFormVO> findByformStatsId(int formStatsId);

    /**
     * 所有订单信息
     * @return 订单集合
     */
    public List<OrderFormVO> findAll();


}
