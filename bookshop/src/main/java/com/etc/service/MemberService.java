package com.etc.service;

import com.etc.pojo.Member;

import java.util.List;

public interface MemberService {

    /**
     * 添加会员
     * @param member 会员对象
     * @return 受影响行数
     */
    public boolean add(Member member);

    /**
     * 根据会员编号删除会员
     * @param memberId 会员编号
     * @return 受影响行数
     */
    public boolean delete(int memberId);

    /**
     * 更新会员信息
     * @param member 会员对象
     * @return 受影响行数
     */
    public boolean update(Member member);

    /**
     * 查询全部会员信息
     * @return 会员对象集合
     */
    public List<Member> findAll();

    /**
     * 按会员卡编号查询
     * @param memberId 会员卡编号
     * @return 会员对象
     */
    public Member findByMid(int memberId);

    /**
     * 按顾客编号查询
     * @param userId 顾客编号
     * @return 会员对象
     */
    public Member findByCtid(int userId);

    /**
     * 按卡类型查询
     * @param mtypeId 卡类型编号
     * @return 会员对象集合
     */
    public List<Member> findByMtid(int mtypeId);
}
