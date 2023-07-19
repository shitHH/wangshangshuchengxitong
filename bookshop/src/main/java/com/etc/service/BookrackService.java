package com.etc.service;

import com.etc.pojo.Bookrack;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author hrf
 * 书架的业务逻辑接口
 */
public interface BookrackService {
    /**
     * 查询到所有书架列表
     * @return 书架列表
     */
    public List<Bookrack> findAll();

    /**
     * 增加一个收藏
     * @param bookrack
     * @return 收藏对象
     */
    public int add(Bookrack bookrack);

    /**
     * 删除一个收藏书籍
     * @param bookId
     * @return
     */
    public int delete(int bookId);

    /**
     * 查询书籍对象
     * @param bookId
     * @return 书籍对象
     */
    public Bookrack findByBookId(int bookId);

    /**
     * 通过用户id查找用户收藏
     * @param userId
     * @return 用户书架列表
     */
    public List<Bookrack> findByuserId(int userId);

    public Bookrack find(@Param("userId")int userId,@Param("bookId")int bookId);
}
