package com.etc.service.impl;

import com.etc.dao.OrderCommodityDao;
import com.etc.pojo.OrderCommodity;
import com.etc.service.OrderCommodityService;
import com.etc.vo.OrderCommodityVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @version v1.0
 * @Author: Slark
 * @Date: Created in2021/11/18  17:29
 * 订单，商品关系表业务逻辑实现类
 */
@Service
public class OrderCommodityServiceImpl implements OrderCommodityService {

    @Resource
    OrderCommodityDao orderCommodityDao;

    @Override
    public boolean add(OrderCommodity orderCommodity) {
        return orderCommodityDao.add(orderCommodity)>0?true:false;
    }

    @Override
    public boolean update(OrderCommodity orderCommodity) {
        return orderCommodityDao.update(orderCommodity)>0?true:false;
    }

    @Override
    public boolean delete(int[] arrays) {
        return orderCommodityDao.delete(arrays)>0?true:false;
    }

    @Override
    public OrderCommodityVO findByOrderCommodityId(int orderCommodityId) {
        return orderCommodityDao.findByOrderCommodityId(orderCommodityId);
    }

    @Override
    public List<OrderCommodityVO> findByorderFormId(int orderFormId) {

        return orderCommodityDao.findByorderFormId(orderFormId);
    }

    @Override
    public List<OrderCommodityVO> findByCommodityId(int commodityId) {
        return orderCommodityDao.findByCommodityId(commodityId);
    }

    @Override
    public List<OrderCommodityVO> findAll() {
        return orderCommodityDao.findAll();
    }
}
