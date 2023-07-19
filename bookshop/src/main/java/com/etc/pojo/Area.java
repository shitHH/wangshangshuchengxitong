package com.etc.pojo;

/**
 * @author Johnny
 * 区县实体类
 */
public class Area {

    private int id;

    private String areaID;

    private String areas;

    private String cityID;

    public Area() {

    }

    public Area(int id, String areaID, String areas, String cityID) {
        this.id = id;
        this.areaID = areaID;
        this.areas = areas;
        this.cityID = cityID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAreaID() {
        return areaID;
    }

    public void setAreaID(String areaID) {
        this.areaID = areaID;
    }

    public String getAreas() {
        return areas;
    }

    public void setAreas(String areas) {
        this.areas = areas;
    }

    public String getCityID() {
        return cityID;
    }

    public void setCityID(String cityID) {
        this.cityID = cityID;
    }
}
