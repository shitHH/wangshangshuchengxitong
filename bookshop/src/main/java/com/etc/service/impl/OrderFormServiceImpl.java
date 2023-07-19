package com.etc.service.impl;


import com.etc.dao.CommodityDao;
import com.etc.dao.OrderCommodityDao;
import com.etc.dao.OrderFormDao;
import com.etc.pojo.Commodity;
import com.etc.pojo.OrderCommodity;
import com.etc.pojo.OrderForm;
import com.etc.service.OrderCommodityService;
import com.etc.service.OrderFormService;
import com.etc.vo.CommodityVO;
import com.etc.vo.OrderCommodityVO;
import com.etc.vo.OrderFormVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * @version v1.0
 * @Author: Slark
 * @Date: Created in2021/11/18  12:16
 * 订单业务逻辑接口实现类
 */
@Service
public class OrderFormServiceImpl implements OrderFormService {
    @Resource
    OrderFormDao orderFormDao;
    @Resource
    CommodityDao commodityDao;


    @Resource
    OrderCommodityDao orderCommodityDao;

    @Override
    public boolean add(OrderForm orderForm) {

        orderForm.setOrderFormDate(new Timestamp(System.currentTimeMillis()));
        return orderFormDao.add(orderForm)>0?true:false;
    }

    @Override
    public boolean update(OrderForm orderForm) {
        return orderFormDao.update(orderForm)>0?true:false;
    }


    @Override
    public boolean delete(int orderFormId) {
        return orderFormDao.delete(orderFormId)>0?true:false;
    }

    @Override
    public List<OrderFormVO> findByformStatsId(int formStatsId) {
        return orderFormDao.findByformStatsId(formStatsId);
    }

    @Override
    public OrderForm findById(int orderFormId) {

        return orderFormDao.findById(orderFormId);
    }

    @Override
    public List<OrderFormVO> findByUserId(int userId) {
        return orderFormDao.findByUserId(userId);
    }

    @Override
    public List<OrderFormVO> findAll() {
        return orderFormDao.findAll();
    }


}
