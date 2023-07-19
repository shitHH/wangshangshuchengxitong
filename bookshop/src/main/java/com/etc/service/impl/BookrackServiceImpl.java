package com.etc.service.impl;


import com.etc.dao.BookrackDao;
import com.etc.pojo.Bookrack;
import com.etc.service.BookrackService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author hrf
 * 书架的业务逻辑实现类
 */

@Service
public class BookrackServiceImpl implements BookrackService {

    Logger logger=Logger.getLogger(BookrackServiceImpl.class);

    @Resource
    BookrackDao bookrackDao;

    @Override
    public List<Bookrack> findAll() {
        return bookrackDao.findAll();
    }

    @Override
    public int add(Bookrack bookrack) {
        return bookrackDao.add(bookrack);
    }

    @Override
    public int delete(int bookId) {
        return bookrackDao.delete(bookId);
    }

    @Override
    public Bookrack findByBookId(int bookId) {
        return bookrackDao.findByBookId(bookId);
    }

    @Override
    public List<Bookrack> findByuserId(int userId) {
        return bookrackDao.findByuserId(userId);
    }

    @Override
    public Bookrack find(int userId, int bookId) {
        return  bookrackDao.find(userId,bookId);
    }
}
