package com.etc.service.impl;

import com.etc.dao.ShoppingDao;
import com.etc.pojo.Shopping;
import com.etc.service.ShoppingService;
import com.etc.vo.ShoppingVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zwh
 * @date 2021/11/17
 * 购物车业务逻辑实现类
 */
@Service
public class ShoppingServiceImpl implements ShoppingService {
    @Autowired
    ShoppingDao shoppingDao;
    @Override
    public List<ShoppingVO> findByUserId(int userId) {
        return shoppingDao.findByUserId(userId);
    }

    @Override
    public ShoppingVO findByShoppingId(int shoppingId) {
        return shoppingDao.findByShoppingId(shoppingId);
    }

    @Override
    public boolean add(Shopping shopping) {
        return shoppingDao.add(shopping)>0?true:false;
    }

    @Override
    public boolean update(Shopping shopping) {
        return shoppingDao.update(shopping)>0?true:false;
    }

    @Override
    public boolean delete(int[] arrays) {
        return shoppingDao.delete(arrays)>0?true:false;
    }
}
