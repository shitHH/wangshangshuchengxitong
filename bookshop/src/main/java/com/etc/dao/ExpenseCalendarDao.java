package com.etc.dao;

import com.etc.pojo.ExpenseCalendar;
import com.etc.vo.ExpenseCalendarVO;

import java.util.List;

/**
 * @version v1.0
 * @Author: Slark
 * @Date: Created in2021/11/18  19:58
 * 消费记录表数据访问接口
 */
public interface ExpenseCalendarDao {

    /**
     * 添加
     * @param expenseCalendar
     * @return
     */
    public int add(ExpenseCalendar expenseCalendar);

    /**
     * 删除
     * @param arrays
     * @return
     */
    public int delete(int[] arrays);

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
