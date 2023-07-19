package com.etc.service.impl;

import com.etc.dao.ChaptersDao;
import com.etc.pojo.Chapters;
import com.etc.service.ChaptersService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author hrf
 * 书籍章节的业务逻辑实现接口
 */
@Service
public class ChaptersServiceImpl implements ChaptersService {


    Logger logger=Logger.getLogger(BookServiceImpl.class);

    @Resource
    ChaptersDao chaptersDao;

    @Override
    public List<Chapters> findAll() {
        return chaptersDao.findAll();
    }

    @Override
    public List<Chapters> findByBookId(int bookId) {
        return chaptersDao.findByBookId(bookId);
    }

    @Override
    public Chapters findByChaptersId(int chaptersId) {
        return chaptersDao.findByChaptersId(chaptersId);
    }

    @Override
    public int add(Chapters chapters) {
        chapters.setChaptersType(2);
        return chaptersDao.add(chapters);
    }

    @Override
    public int update(Chapters chapters) {
        return chaptersDao.update(chapters);
    }

    @Override
    public int delete(int chaptersId) {
        return chaptersDao.delete(chaptersId);
    }
}
