package com.etc.service;

import com.etc.pojo.Blogs;
import com.etc.vo.BlogsCharts;
import com.etc.vo.BlogsVO;

import java.util.List;
import java.util.Map;

/**
 * @author zwh
 * @date 2021/11/18
 * 博客业务逻辑接口
 */
public interface BlogsService {
    /**
     * @return 博客列表
     */
    public List<BlogsVO> findAll();

    /**
     * @param blogsId 博客编号
     * @return 博客对象
     */
    public BlogsVO findByBolgdId(int blogsId);

    /**
     * @param userId 用户ID
     * @return
     */
    public List<BlogsVO> findByUserId(int userId);

    /**
     * @param blogs 博客对象
     * @return 受影响行数
     */
    public boolean add(Blogs blogs);

    /**
     * @param blogs 博客对象
     * @return 受影响行数
     */
    public boolean update(Blogs blogs);

    /**
     * @param arrays 集合
     * @return 受影响行数
     */
    public boolean delete(int[] arrays);

    /**
     * 查询帖子统计饼状图
     * @return 帖子统计对象集合
     */
    public List<BlogsCharts> findStat();


    /**
     * 柱状图
     * @return
     */
    public Map<String,List> findStatBar();
}
