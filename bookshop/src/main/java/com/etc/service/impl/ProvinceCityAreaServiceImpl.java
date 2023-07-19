package com.etc.service.impl;

import com.etc.dao.ProvinceCityAreaDao;
import com.etc.pojo.Area;
import com.etc.pojo.City;
import com.etc.pojo.Province;
import com.etc.service.ProvinceCityAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author dff
 * 省市区三合一业务逻辑实现类
 */
@Service
public class ProvinceCityAreaServiceImpl implements ProvinceCityAreaService {

    @Resource
    ProvinceCityAreaDao pcadao;

    @Override
    public List<Province> findAllProvince() {
        return pcadao.findAllProvince();
    }

    @Override
    public List<City> findAllCityByProvinceID(String provinceID) {
        return pcadao.findAllCityByProvinceID(provinceID);
    }

    @Override
    public List<Area> findAllAreaByCityID(String cityID) {
        return pcadao.findAllAreaByCityID(cityID);
    }

    @Override
    public Province findByprovinceID(String provinceID) {
        return pcadao.findByprovinceID(provinceID);
    }

    @Override
    public City findBycityID(String cityID) {
        return pcadao.findBycityID(cityID);
    }

    @Override
    public Area findByareaID(String areaID) {
        return pcadao.findByareaID(areaID);
    }
}
