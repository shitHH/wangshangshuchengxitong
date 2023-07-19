package com.etc.service;

import com.etc.pojo.Area;
import com.etc.pojo.City;
import com.etc.pojo.Province;

import java.util.List;

/**
 * @author Johnny
 * 省市区三合一业务逻辑接口
 */
public interface ProvinceCityAreaService {
    /**
     * 查询所有的省
     * @return 省（直辖市）的集合
     */
    public List<Province> findAllProvince();

    /**
     * 根据省编号，查询该省的所有城市
     * @param provinceID 省的编号
     * @return 城市集合
     */
    public List<City> findAllCityByProvinceID(String provinceID);

    /**
     * 根据市的编号，查询该市下的所有区县
     * @param cityID 城市编号
     * @return 区县集合
     */
    public List<Area> findAllAreaByCityID(String cityID);
    /**
     * 根据省编号查询省名称
     * @param provinceID
     * @return
     */
    public Province findByprovinceID(String provinceID);

    /**
     * 根据市编号查询市名称
     * @param cityID
     * @return
     */
    public City findBycityID(String cityID);

    /**
     * 根据区编号查询区名称
     * @param areaID
     * @return
     */
    public Area findByareaID(String areaID);
}
