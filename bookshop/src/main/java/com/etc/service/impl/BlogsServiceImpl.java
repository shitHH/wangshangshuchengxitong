package com.etc.service.impl;

import com.etc.dao.BlogsDao;
import com.etc.pojo.Blogs;
import com.etc.service.BlogsService;
import com.etc.service.CommentService;
import com.etc.vo.BlogsCharts;
import com.etc.vo.BlogsVO;
import com.etc.vo.CommentVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.*;

/**
 * @author zwh
 * @date 2021/11/18
 * 博客业务逻辑实现类
 */
@Service
public class BlogsServiceImpl implements BlogsService {
    @Autowired
    BlogsDao blogsDao;
    @Autowired
    CommentService commentService;

    @Override
    public List<BlogsVO> findAll() {
        List<BlogsVO> list = blogsDao.findAll();
        if(list!=null){
            for (BlogsVO b:list
                 ) {
                int blogsheat=commentService.findByBlogs(b.getBlogsId()).size();
                b.setBolgsHeat(blogsheat);
            }
        }
        return list;
    }

    @Override
    public BlogsVO findByBolgdId(int blogsId) {
        return blogsDao.findByBolgdId(blogsId);
    }

    @Override
    public List<BlogsVO> findByUserId(int userId) {
        return blogsDao.findByUserId(userId);
    }

    @Override
    public boolean add(Blogs blogs) {
        blogs.setBlogsCtime(new Timestamp(new Date().getTime()));
        return blogsDao.add(blogs)>0;
    }

    @Override
    public boolean update(Blogs blogs) {
        return blogsDao.update(blogs)>0;
    }

    @Override
    public boolean delete(int[] arrays) {
        for (int i=0;i<arrays.length;i++){
            List<CommentVO> list = commentService.findByBlogs(arrays[i]);
            if(list!=null){
                commentService.delete(arrays[i]);
            }
        }
        return blogsDao.delete(arrays)>0;
    }

    @Override
    public List<BlogsCharts> findStat() {
        return blogsDao.findStat();
    }

    @Override
    public Map<String, List> findStatBar() {
        Map<String,List> map = new HashMap<>();
        List<String> name = new ArrayList<>();
        List<String> value = new ArrayList<>();
        List<Integer> heats = new ArrayList<>();

        List<BlogsCharts> list = blogsDao.findStat();
        for (BlogsCharts b:list
             ) {
            int heatsnum = 0;
            List<BlogsVO> userlist= blogsDao.findByUserId(b.getUserId());
            for (BlogsVO bv:userlist
                 ) {
                heatsnum+=commentService.findByBlogs(bv.getBlogsId()).size();
            }
            name.add(b.getName());
            value.add(b.getValue());
            heats.add(heatsnum);
        }
        map.put("names",name);
        map.put("values",value);
        map.put("heats",heats);
        return map;
    }


}
