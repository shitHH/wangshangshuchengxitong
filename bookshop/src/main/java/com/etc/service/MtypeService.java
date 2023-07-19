package com.etc.service;

import com.etc.pojo.Mtype;

import java.util.List;

/**
 * @author ls
 * @category
 */
public interface MtypeService {

    /**
     * 添加会员卡类型
     * @param mtype 会员卡类型对象
     * @return 受影响行数
     */
    public boolean add(Mtype mtype);

    /**
     * 根据会员卡类型编号删除会员卡类型
     * @param mtypeId 会员卡类型编号
     * @return 受影响行数
     */
    public boolean delete(int mtypeId);

    /**
     * 更新会员卡类型
     * @param mtype 会员卡类型对象
     * @return 受影响行数
     */
    public boolean update(Mtype mtype);


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
