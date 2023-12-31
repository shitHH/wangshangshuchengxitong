package com.etc.pojo;

/**
 * @author Johnny
 * 省实体类
 */
public class Province {

    private int id;

    private String provinceID;

    private String province;

    public Province() {
    }

    public Province(int id, String provinceID, String province) {
        this.id = id;
        this.provinceID = provinceID;
        this.province = province;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProvinceID() {
        return provinceID;
    }

    public void setProvinceID(String provinceID) {
        this.provinceID = provinceID;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }
}
