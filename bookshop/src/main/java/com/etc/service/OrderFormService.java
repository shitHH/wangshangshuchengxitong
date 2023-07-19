package com.etc.service;

import com.etc.pojo.OrderForm;
import com.etc.vo.OrderFormVO;

import java.util.List;

/**
 * @version v1.0
 * @Author: Slark
 * @Date: Created in2021/11/18  12:14
 * 订单表业务逻辑接口
 */
public interface OrderFormService {

    /**
     * 添加订单
     * @param orderForm
     * @return 是否添加成功
     */
    public boolean add(OrderForm orderForm);

    /**
     * 更新订单
     * @param orderForm
     * @return 是否更新成功
     */
    public boolean update(OrderForm orderForm);

    /**
     *  删除订单信息
     * @param orderFormId
     * @return
     * 是否删除成功
     */
    public boolean delete(int orderFormId);

    /**
     * 根据订单编号查询订单信息
     * @param orderFormId
     * @return 订单详情
     */
    public OrderForm findById(int orderFormId);

    /**
     * 根据订单状态ID查询
     * @param formStatsId
     * @return
     */
    public List<OrderFormVO> findByformStatsId(int formStatsId);

    /**
     * 根据订单编号查询订单信息
     * @param userId
     * @return 订单详情
     */
    public List<OrderFormVO> findByUserId(int userId);

    /**
     * 所有订单信息
     * @return 订单集合
     */
    public List<OrderFormVO> findAll();
}
