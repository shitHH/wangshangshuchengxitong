package com.etc.service.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.etc.dao.SortDao;
import com.etc.pojo.Sort;
import com.etc.service.SortService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zwh
 * @date 2021/11/17
 * 分类表业务逻辑实现类
 */
@Service
public class SortServiceImpl implements SortService {
    @Resource
    SortDao sortDao;

    @Override
    public Sort findBySortId(int sortId) {
        return sortDao.findBySortId(sortId);
    }

    @Override
    public List<Sort> findByBook() {
        return sortDao.findByBook();
    }

    @Override
    public List<Sort> findByBook1() {
        return sortDao.findByBook1();
    }

    @Override
    public List<Sort> findCommodity(int sortOrder) {
        return sortDao.findCommodity(sortOrder);
    }

    @Override
    public List<Sort> findByCommodity() {
        return sortDao.findByCommodity();
    }

    @Override
    public List<Sort> findByParentId(int parentId) {
        return sortDao.findByParentId(parentId);
    }

    @Override
    public boolean add(Sort sort) {
        return sortDao.add(sort)>0?true:false;
    }

    @Override
    public boolean update(Sort sort) {
        return sortDao.update(sort)>0?true:false;
    }

    @Override
    public List<Sort> findBySortOrder(int sortOrder) {
        return sortDao.findBySortOrder(sortOrder);
    }
}
