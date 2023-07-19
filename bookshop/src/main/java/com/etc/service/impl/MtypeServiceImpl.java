package com.etc.service.impl;

import com.etc.dao.MtypeDao;
import com.etc.pojo.Mtype;
import com.etc.service.MtypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author ls
 * @category
 */
@Service
public class MtypeServiceImpl implements MtypeService {
    @Resource
    MtypeDao mtypeDao;
    @Override
    public boolean add(Mtype mtype) {
        return mtypeDao.add(mtype)>0?true:false;
    }

    @Override
    public boolean delete(int mtypeId) {
        return mtypeDao.delete(mtypeId)>0?true:false;
    }

    @Override
    public boolean update(Mtype mtype) {
        return mtypeDao.update(mtype)>0?true:false;
    }

    @Override
    public List<Mtype> findAll() {
        return mtypeDao.findAll();
    }

    @Override
    public Mtype findByMtid(int mtypeId) {
        return mtypeDao.findByMtid(mtypeId);
    }
}
