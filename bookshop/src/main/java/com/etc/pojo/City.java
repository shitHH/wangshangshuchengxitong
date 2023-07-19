package com.etc.pojo;

/**
 * @author Johnny
 * 城市实体类
 */
public class City {

    private int id;

    private String cityID;

    private String city;

    private String provinceID;

    public City() {

    }

    public City(int id, String cityID, String city, String provinceID) {
        this.id = id;
        this.cityID = cityID;
        this.city = city;
        this.provinceID = provinceID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCityID() {
        return cityID;
    }

    public void setCityID(String cityID) {
        this.cityID = cityID;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvinceID() {
        return provinceID;
    }

    public void setProvinceID(String provinceID) {
        this.provinceID = provinceID;
    }
}
