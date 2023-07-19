package com.etc.dao;

import com.etc.pojo.Shopping;
import com.etc.vo.ShoppingVO;

import java.util.List;

/**
 * @author zwh
 * @date 2021/11/17
 * 购物车数据访问接口
 */
public interface ShoppingDao {

    /**
     * 查询个人购物车
     * @param userId 人员编号
     * @return 购物车视图对象集合
     */
    public List<ShoppingVO> findByUserId(int userId);

    /**
     * 根据购物车编号查询
     * @param shoppingId 购物车编号
     * @return 购物车视图对象
     */
    public ShoppingVO findByShoppingId(int shoppingId);

    /**
     * 添加购物车信息
     * @param shopping 购物车对象
     * @return 受影响行数
     */
    public int add(Shopping shopping);

    /**
     * 更新购物车信息
     * @param shopping 购物车对象
     * @return 受影响行数
     */
    public int update(Shopping shopping);

    /**
     * 删除购物车信息
     * @param arrays 购物车编号数组
     * @return 受影响行数
     */
    public int delete(int[] arrays);
}
