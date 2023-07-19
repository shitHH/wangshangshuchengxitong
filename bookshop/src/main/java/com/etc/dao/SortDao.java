package com.etc.dao;

import com.etc.pojo.Sort;

import java.util.List;

/**
 * @author zwh
 * @date 2021/11/17
 * 分类表数据访问接口
 */
public interface SortDao {

    /**
     * 查询所有书籍跟目录标签(1)
     * @return 类型集合
     */
    public List<Sort> findByBook();

    /**
     * 查询所有书籍跟目录标签(1)
     * @return 类型集合
     */
    public List<Sort> findByBook1();

    /**
     * 查询所有商品跟目录标签
     * @param sortOrder
     * @return 类型集合
     */
    public List<Sort> findCommodity(int sortOrder);

    /**
     * 查询所有商品跟目录标签(2)
     * @return 类型集合
     */
    public List<Sort> findByCommodity();

    /**
     * 根据父节点查询子节点
     * @param parentId
     * @return 类型集合
     */
    public List<Sort> findByParentId(int parentId);


    /**
     * 根据类型编号查询
     * @param sortId 类型编号
     * @return 类型对象
     */
    public Sort findBySortId(int sortId);

    /**
     * 新增类别
     * @param sort 类别对象
     * @return 受影响行数
     */
    public int add(Sort sort);

    /**
     * 更新类别
     * @param sort 类别对象
     * @return 受影响行数
     */
    public int update(Sort sort);


    /**
     * 通过查找sortOrder得到列表集合
     * @param sortOrder
     * @return 列表集合
     */
    public List<Sort> findBySortOrder(int sortOrder);
}
