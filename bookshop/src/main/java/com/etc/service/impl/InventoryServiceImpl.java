package com.etc.service.impl;

import com.etc.dao.InventoryDao;
import com.etc.pojo.Inventory;
import com.etc.service.InventoryService;
import com.etc.vo.InventoryVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zwh
 * @date 2021/11/17
 * 仓库业务逻辑实现类
 */
@Service
public class InventoryServiceImpl implements InventoryService {
    @Autowired
    InventoryDao inventoryDao;

    @Override
    public List<InventoryVO> findAll() {
        return inventoryDao.findAll();
    }

    @Override
    public InventoryVO findByInventoryId(int inventoryId) {
        return inventoryDao.findByInventoryId(inventoryId);
    }

    @Override
    public InventoryVO findByCommodityId(int commodityId) {
        return inventoryDao.findByCommodityId(commodityId);
    }

    @Override
    public boolean add(Inventory inventory) {
        return inventoryDao.add(inventory)>0?true:false;
    }

    @Override
    public boolean update(Inventory inventory) {
        return inventoryDao.update(inventory)>0?true:false;
    }
}
