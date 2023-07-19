package com.etc.vo;

/**
 * @author zwh
 * @date 2021/11/22
 * 书籍图表信息VO
 */
public class BookCharts {

    /**
     * 书籍类型名称
     */
    private String name;

    /**
     * 当前类型书籍数量
     */
    private String value;

    public BookCharts() {
    }

    public BookCharts(String name, String value) {
        this.name = name;
        this.value = value;
    }

    @Override
    public String toString() {
        return "BookCharts{" +
                "name='" + name + '\'' +
                ", value='" + value + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
