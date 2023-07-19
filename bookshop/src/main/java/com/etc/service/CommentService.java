package com.etc.service;

import com.etc.pojo.Comment;
import com.etc.vo.CommentVO;

import java.util.List;

/**
 * @author zwh
 * @date 2021/11/17
 * 评论表业务逻辑接口
 */
public interface CommentService {

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
     * 新增一条评论
     * @param comment 评论对象
     * @return 是否添加成功
     */
    public boolean add(Comment comment);

    /**
     * 删除一条评论
     * @param commentId  评论编号
     * @return 是否删除成功
     */
    public boolean delete(int commentId);

    /**
     * 根据评论编号查询
     * @param commentId 评论编号
     * @return 评论对象
     */
    public CommentVO findByCommentId(int commentId);
}
