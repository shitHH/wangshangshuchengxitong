package com.etc.dao;

import com.etc.pojo.Blogs;
import com.etc.vo.BlogsCharts;
import com.etc.vo.BlogsVO;

import java.util.List;

/**
 * @author XS
 * 博客数据访问接口
 */
public interface BlogsDao {
    /**
     * @return 博客列表
     */
    public List<BlogsVO>  findAll();

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
    public int add(Blogs blogs);

    /**
     * @param blogs 博客对象
     * @return 受影响行数
     */
    public int update(Blogs blogs);

    /**
     * @param arrays 集合
     * @return 受影响行数
     */
    public int delete(int[] arrays);


    /**
     * 查询帖子统计
     *
     * @return 帖子统计对象集合
     */
    public List<BlogsCharts> findStat();
}
