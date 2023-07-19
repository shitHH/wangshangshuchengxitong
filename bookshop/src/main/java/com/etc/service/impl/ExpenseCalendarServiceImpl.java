package com.etc.service.impl;

import com.etc.dao.ExpenseCalendarDao;
import com.etc.pojo.ExpenseCalendar;
import com.etc.service.ExpenseCalendarService;
import com.etc.vo.ExpenseCalendarVO;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @version v1.0
 * @Author: Slark
 * @Date: Created in2021/11/18  20:12
 */
@Service
public class ExpenseCalendarServiceImpl implements ExpenseCalendarService {

    @Resource
    ExpenseCalendarDao expenseCalendarDao;

    @Override
    public boolean add(ExpenseCalendar expenseCalendar) {
        return expenseCalendarDao.add(expenseCalendar)>0?true:false;
    }

    @Override
    public boolean delete(int[] arrays) {
        return expenseCalendarDao.delete(arrays)>0?true:false;
    }

    @Override
    public ExpenseCalendarVO findById(int expenseCalendarId) {
        return expenseCalendarDao.findById(expenseCalendarId);
    }

    @Override
    public List<ExpenseCalendarVO> findByUserId(int userId) {
        return expenseCalendarDao.findByUserId(userId);
    }

    @Override
    public List<ExpenseCalendarVO> findAll() {
        return expenseCalendarDao.findAll();
    }
}
