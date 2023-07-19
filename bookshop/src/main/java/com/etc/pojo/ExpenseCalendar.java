package com.etc.pojo;

/**
 * @author zwh
 * @date 2021/11/17
 * 消费记录类
 */
public class ExpenseCalendar {

    /**
     * 消费记录编号
     */
    private int expenseCalendarId;

    /**
     * 消费金额
     */
    private double expenseCalendarPrice;

    /**
     * 人员id
     */
    private int userId;

    /**
     * 消费内容
     */
    private String expenseCalendarContent;

    public ExpenseCalendar() {
    }

    public ExpenseCalendar(int expenseCalendarId, double expenseCalendarPrice, int userId, String expenseCalendarContent) {
        this.expenseCalendarId = expenseCalendarId;
        this.expenseCalendarPrice = expenseCalendarPrice;
        this.userId = userId;
        this.expenseCalendarContent = expenseCalendarContent;
    }

    @Override
    public String toString() {
        return "ExpenseCalendar{" +
                "expenseCalendarId=" + expenseCalendarId +
                ", expenseCalendarPrice=" + expenseCalendarPrice +
                ", userId=" + userId +
                ", expenseCalendarContent='" + expenseCalendarContent + '\'' +
                '}';
    }

    public int getExpenseCalendarId() {
        return expenseCalendarId;
    }

    public void setExpenseCalendarId(int expenseCalendarId) {
        this.expenseCalendarId = expenseCalendarId;
    }

    public double getExpenseCalendarPrice() {
        return expenseCalendarPrice;
    }

    public void setExpenseCalendarPrice(double expenseCalendarPrice) {
        this.expenseCalendarPrice = expenseCalendarPrice;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getExpenseCalendarContent() {
        return expenseCalendarContent;
    }

    public void setExpenseCalendarContent(String expenseCalendarContent) {
        this.expenseCalendarContent = expenseCalendarContent;
    }
}
