package com.etc.vo;

import java.util.Date;

/**
 * @author ls
 * @category
 * 用户vo实体类
 */
public class UserVO {
    /**
     * 人员编号
     */
    private int userId;

    /**
     * 角色编号
     */
    private int roleId;

    /**
     * 角色名称
     */
    private String roleName;

    /**
     * 人员姓名
     */
    private String userName;

    /**
     * 人员登录密码
     */
    private String userPassword;

    /**
     * 人员性别
     */
    private char userSex;

    /**
     * 人员生日
     */
    private Date userBirthday;

    /**
     * 人员年龄
     */
    private int userAge;

    /**
     * 人员来自市区
     */
    private String userCity;

    /**
     * 人员电话
     */
    private String userTel;

    /**
     * 人员邮箱
     */
    private String userEmail;

    /**
     * 人员证件号
     */
    private String userIdNumber;

    /**
     * 头像链接地址
     */
    private String userPhoto;

    /**
     * 账户余额
     */
    private double userBalance;

    /**
     * 是否是会员0不是1是
     */
    private int memberStats;

    public UserVO() {
    }

    public UserVO(int userId, int roleId, String roleName, String userName, String userPassword, char userSex, Date userBirthday, int userAge, String userCity, String userTel, String userEmail, String userIdNumber, String userPhoto, double userBalance, int memberStats) {
        this.userId = userId;
        this.roleId = roleId;
        this.roleName = roleName;
        this.userName = userName;
        this.userPassword = userPassword;
        this.userSex = userSex;
        this.userBirthday = userBirthday;
        this.userAge = userAge;
        this.userCity = userCity;
        this.userTel = userTel;
        this.userEmail = userEmail;
        this.userIdNumber = userIdNumber;
        this.userPhoto = userPhoto;
        this.userBalance = userBalance;
        this.memberStats = memberStats;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public char getUserSex() {
        return userSex;
    }

    public void setUserSex(char userSex) {
        this.userSex = userSex;
    }

    public Date getUserBirthday() {
        return userBirthday;
    }

    public void setUserBirthday(Date userBirthday) {
        this.userBirthday = userBirthday;
    }

    public int getUserAge() {
        return userAge;
    }

    public void setUserAge(int userAge) {
        this.userAge = userAge;
    }

    public String getUserCity() {
        return userCity;
    }

    public void setUserCity(String userCity) {
        this.userCity = userCity;
    }

    public String getUserTel() {
        return userTel;
    }

    public void setUserTel(String userTel) {
        this.userTel = userTel;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserIdNumber() {
        return userIdNumber;
    }

    public void setUserIdNumber(String userIdNumber) {
        this.userIdNumber = userIdNumber;
    }

    public String getUserPhoto() {
        return userPhoto;
    }

    public void setUserPhoto(String userPhoto) {
        this.userPhoto = userPhoto;
    }

    public double getUserBalance() {
        return userBalance;
    }

    public void setUserBalance(double userBalance) {
        this.userBalance = userBalance;
    }

    public int getMemberStats() {
        return memberStats;
    }

    public void setMemberStats(int memberStats) {
        this.memberStats = memberStats;
    }
}
