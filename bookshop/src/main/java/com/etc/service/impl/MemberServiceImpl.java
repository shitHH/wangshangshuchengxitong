package com.etc.service.impl;

import com.etc.dao.MemberDao;
import com.etc.pojo.Member;
import com.etc.service.MemberService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author ls
 * @category
 */
public class MemberServiceImpl implements MemberService {
    @Resource
    MemberDao memberDao;
    @Override
    public boolean add(Member member) {
        return memberDao.add(member)>0?true:false ;
    }

    @Override
    public boolean delete(int memberId) {
        return false;
    }

    @Override
    public boolean update(Member member) {
        return memberDao.update(member)>0?true:false;
    }

    @Override
    public List<Member> findAll() {
        return memberDao.findAll();
    }

    @Override
    public Member findByMid(int memberId) {
        return null;
    }

    @Override
    public Member findByCtid(int userId) {
        return null;
    }

    @Override
    public List<Member> findByMtid(int mtypeId) {
        return null;
    }
}
