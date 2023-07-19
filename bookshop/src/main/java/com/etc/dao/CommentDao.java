package com.etc.dao;

import com.etc.pojo.Comment;
import com.etc.vo.CommentVO;

import java.util.List;

/**
 * @author zwh
 * @date 2021/11/17
 * 评论表数据访问接口
 */
public interface CommentDao {
    /**
     * 查询一本书下所有楼层评论
     * @param bookId 书籍编号(1)
     * @return 评论对象集合
     */
    public List<CommentVO> findByBook(int bookId);

    /**
     * 查询一商品下所有楼层评论(2)
     * @param commodityId  商品编号
     * @return 评论对象集合
     */
    public List<CommentVO> findByCommodity(int commodityId);

    /**
     * 查询一说说下所有楼层评论(3)
     * @param blogsId  说说编号
     * @return 评论对象集合
     */
    public List<CommentVO> findByBlogs(int blogsId);

    /**
     * 根据父节点查询所有子评论
     * @param cparentId 父节点编号
     * @return 评论对象集合
     */
    public List<CommentVO> findByCparentId(int cparentId);


    /**
     * 根据评论编号查询
     * @param commentId 评论编号
     * @return 评论对象
     */
    public CommentVO findByCommentId(int commentId);
    /**
     * 新增一条评论
     * @param comment 评论对象
     * @return 受影响行数
     */
    public int add(Comment comment);

    /**
     * 删除一条评论
     * @param commentId  评论编号
     * @return 受影响行数
     */
    public int delete(int commentId);
}
