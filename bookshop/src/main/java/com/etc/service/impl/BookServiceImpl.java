package com.etc.service.impl;

import com.etc.dao.BookDao;
import com.etc.pojo.Book;
import com.etc.service.BookService;
import com.etc.vo.BookCharts;
import com.etc.vo.BookVO;
import jdk.nashorn.internal.ir.annotations.Reference;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BookServiceImpl implements BookService {

    Logger logger=Logger.getLogger(BookServiceImpl.class);

    @Resource
    BookDao bookDao;


    @Override
    public List<Book> findAll() {
        return bookDao.findAll();
    }

    @Override
    public Book findById(int bookId) {
        return bookDao.findById(bookId);
    }

    @Override
    public List<BookVO> findList(int bookId) {
        return bookDao.findList(bookId);
    }

    @Override
    public List<Book> findBysortIdOne(int sortIdOne) {
        return bookDao.findBysortIdOne(sortIdOne);
    }

    @Override
    public List<Book> findBysortIdTwo(int sortIdTwo) {
        return bookDao.findBysortIdTwo(sortIdTwo);
    }

    @Override
    public List<Book> findBysortIdThree(int sortIdThree) {
        return bookDao.findBysortIdThree(sortIdThree);
    }

    @Override
    public boolean update(Book book) {
        return bookDao.update(book);
    }

    @Override
    public int add(Book bookId) {
        return bookDao.add(bookId);
    }

    @Override
    public int delete(int bookId) {
        return bookDao.delete(bookId);
    }

    @Override
    public List<BookCharts> findStat() {
        return bookDao.findStat();
    }

    @Override
    public Map<String, List> findStatBar() {
        Map<String, List> map = new HashMap<>();
        List<String> names = new ArrayList<>();
        List<String> values = new ArrayList<>();
        List<BookCharts> list=bookDao.findStat();
        for (BookCharts b:list
             ) {
            names.add(b.getName());
            values.add(b.getValue());
        }
        map.put("names",names);
        map.put("values",values);

        return map;
    }
}
