package com.etc.service.impl;

import com.etc.dao.CommentDao;
import com.etc.pojo.Comment;
import com.etc.service.CommentService;
import com.etc.vo.CommentVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

/**
 * @author zwh
 * @date 2021/11/17
 */
@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    CommentDao commentDao;
    @Override
    public List<CommentVO> findByBook(int bookId) {
        return commentDao.findByBook(bookId);
    }

    @Override
    public List<CommentVO> findByCommodity(int commodityId) {
        return commentDao.findByCommodity(commodityId);
    }

    @Override
    public List<CommentVO> findByBlogs(int blogsId) {
        return commentDao.findByBlogs(blogsId);
    }

    @Override
    public List<CommentVO> findByCparentId(int cparentId) {
        return commentDao.findByCparentId(cparentId);
    }

    @Override
    public boolean add(Comment comment) {
        comment.setCommentCtime(new Timestamp(System.currentTimeMillis()));
        return commentDao.add(comment)>0?true:false;
    }

    @Override
    public boolean delete(int commentId) {
        boolean flag=false;
        CommentVO comment = commentDao.findByCommentId(commentId);
        if(comment!=null&&comment.getCparentId()==0){
            List<CommentVO> list = commentDao.findByCparentId(commentId);
            if(list!=null){
                for (CommentVO c:list
                     ) {
                    commentDao.delete(c.getCommentId());
                }
                flag=commentDao.delete(commentId)>0?true:false;
            }else {
                flag=commentDao.delete(commentId)>0?true:false;
            }
        }else {
            flag=commentDao.delete(commentId)>0?true:false;
        }
        return flag;
    }

    @Override
    public CommentVO findByCommentId(int commentId) {
        return commentDao.findByCommentId(commentId);
    }
}
