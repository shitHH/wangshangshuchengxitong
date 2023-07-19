package com.etc.service;

import com.etc.pojo.ExpenseCalendar;
import com.etc.vo.ExpenseCalendarVO;

import java.util.List;

/**
 * @version v1.0
 * @Author: Slark
 * @Date: Created in2021/11/18  20:11
 * 消费记录业务逻辑类
 */
public interface ExpenseCalendarService {
    /**
     * 添加
     * @param expenseCalendar
     * @return
     */
    public boolean add(ExpenseCalendar expenseCalendar);

    /**
     * 删除
     * @param arrays
     * @return
     */
    public boolean delete(int[] arrays);

    /**
     * 根据消费记录编号查询消费记录
     * @return
     */
    public ExpenseCalendarVO findById(int expenseCalendarId);

    /**
     * 根据用户id查询消费记录
     * @return
     */
    public List<ExpenseCalendarVO> findByUserId(int userId);

    /**
     * 查询所有消费记录
     * @return
     */
    public List<ExpenseCalendarVO> findAll();
}
