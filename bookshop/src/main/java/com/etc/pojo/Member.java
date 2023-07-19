package com.etc.pojo;

import java.sql.Timestamp;

/**
 * @author zwh
 * @date 2021/11/17
 * 会员类
 */
public class Member {

    /**
     * 会员卡编号
     */
    private int memberId;

    /**
     * 人员编号
     */
    private int userId;

    /**
     * 会员到期时间
     */
    private Timestamp memberExpire;

    /**
     * 会员积分
     */
    private int memberIntegral;

    public Member() {
    }

    public Member(int memberId, int userId, Timestamp memberExpire, int memberIntegral) {
        this.memberId = memberId;
        this.userId = userId;
        this.memberExpire = memberExpire;
        this.memberIntegral = memberIntegral;
    }

    @Override
    public String toString() {
        return "Member{" +
                "memberId=" + memberId +
                ", userId=" + userId +
                ", memberExpire=" + memberExpire +
                ", memberIntegral=" + memberIntegral +
                '}';
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Timestamp getMemberExpire() {
        return memberExpire;
    }

    public void setMemberExpire(Timestamp memberExpire) {
        this.memberExpire = memberExpire;
    }

    public int getMemberIntegral() {
        return memberIntegral;
    }

    public void setMemberIntegral(int memberIntegral) {
        this.memberIntegral = memberIntegral;
    }
}
