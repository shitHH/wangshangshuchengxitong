package com.etc.dao;

import com.etc.pojo.Mtype;

import java.util.List;

/**
 * @author ls
 * 会员种类数据访问接口
 */
public interface MtypeDao {

    /**
     * 添加会员卡类型
     * @param mtype 会员卡类型对象
     * @return 受影响行数
     */
    public int add(Mtype mtype);

    /**
     * 根据会员卡类型编号删除会员卡类型
     * @param mtypeId 会员卡类型编号
     * @return 受影响行数
     */
    public int delete(int mtypeId);

    /**
     * 更新会员卡类型
     * @param mtype 会员卡类型对象
     * @return 受影响行数
     */
    public int update(Mtype mtype);


    /**
     * 查询全部会员卡类型
     * @return 会员卡类型对象集合
     */
    public List<Mtype> findAll();

    /**
     * 根据会员卡类型编号查找会员类型
     * @param mtypeId 会员类型编号
     * @return 会员类型对象
     */
    public Mtype findByMtid(int mtypeId);
}
