package com.etc.service.impl;

import com.etc.dao.CommodityDao;
import com.etc.dao.SortDao;

import com.etc.pojo.Commodity;
import com.etc.service.CommentService;
import com.etc.service.CommodityService;
import com.etc.vo.BookCharts;
import com.etc.vo.CommentVO;
import com.etc.vo.CommodityVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zwh
 * @date 2021/11/18
 * 商品业务逻辑实现类
 */
@Service
public class CommodityServiceImpl implements CommodityService {
    @Autowired
    CommodityDao commodityDao;
    @Autowired
    SortDao sortDao;


    @Override
    public List<CommodityVO> findAll() {
        List<CommodityVO> list = commodityDao.findAll();
        if(list!=null){
            for (CommodityVO c:list
            ) {
                int sortIdOne= c.getSortIdOne();
                int sortIdTwo= c.getSortIdTwo();
                int sortIdThree= c.getSortIdThree();
                if(sortIdOne!=0){
                    String sortIdOneName = sortDao.findBySortId(sortIdOne).getSortName();
                    c.setSortIdOneName(sortIdOneName);
                }
                if(sortIdTwo!=0){
                    String sortIdTwoName = sortDao.findBySortId(sortIdTwo).getSortName();
                    c.setSortIdTwoName(sortIdTwoName);
                }
                if(sortIdThree!=0){
                    String sortIdThreeName = sortDao.findBySortId(sortIdThree).getSortName();
                    c.setSortIdThreeName(sortIdThreeName);
                }
            }
        }
        return list;
    }

    @Override
    public List<CommodityVO> findBySortIdOne(@Param("sortIdOne") int sortIdOne,@Param("companyStats") int companyStats) {
        List<CommodityVO> list = commodityDao.findBySortIdOne(sortIdOne,companyStats);
        return list;
    }

    @Override
    public List<CommodityVO> findBySortIdTwo(@Param("sortIdTwo") int sortIdTwo,@Param("companyStats") int companyStats) {
        List<CommodityVO> list = commodityDao.findBySortIdTwo(sortIdTwo,companyStats);
        return list;
    }

    @Override
    public List<CommodityVO> findBySortIdThree(@Param("sortIdThree") int sortIdThree,@Param("companyStats") int companyStats) {
        List<CommodityVO> list = commodityDao.findBySortIdThree(sortIdThree,companyStats);
        return list;
    }

    @Override
    public CommodityVO findByCommodityId(int commodityId) {
        CommodityVO commodityVO = commodityDao.findByCommodityId(commodityId);
        return commodityVO;
    }

    @Override
    public List<CommodityVO> findByCompanyStats(int companyStats) {
        List<CommodityVO> list = commodityDao.findByCompanyStats(companyStats);
        return list;
    }

    @Override
    public boolean add(Commodity commodity) {
        return commodityDao.add(commodity)>0?true:false;
    }

    @Override
    public boolean update(Commodity commodity) {
        return commodityDao.update(commodity)>0?true:false;
    }

    @Override
    public List<BookCharts> findStat() {
        return commodityDao.findStat();
    }

    @Override
    public Map<String, List> findStatBar() {
        Map<String, List> map = new HashMap<>();
        List<String> names = new ArrayList<>();
        List<String> values = new ArrayList<>();
        List<BookCharts> list=commodityDao.findStat();
        for (BookCharts b:list
        ) {
            names.add(b.getName());
            values.add(b.getValue());
        }
        map.put("names",names);
        map.put("values",values);

        return map;
    }
}
