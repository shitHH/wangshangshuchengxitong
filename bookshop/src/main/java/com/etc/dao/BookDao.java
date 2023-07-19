package com.etc.dao;

import com.etc.pojo.Book;
import com.etc.vo.BookCharts;
import com.etc.vo.BookVO;

import java.util.List;

/**
 * @author hrf
 * 书籍列表的数据访问接口
 */
public interface BookDao {
    /**
     * 查询所有书籍
     * @return 书籍列表
     */
    public List<Book> findAll();

    /**
     * 通过id查询书籍列表
     * @return id书籍列表
     */
    public Book findById(int bookId);

    /**
     * 将书籍表和书籍章节表进行联查
     * @param bookId
     * @return 联查列表
     */
    public List<BookVO> findList(int bookId);

    /**
     * 通过一级编号进行查询（）
     * @param sortIdOne
     * @return （）书籍列表
     */
    public List<Book> findBysortIdOne(int sortIdOne);

    /**
     * 通过二级编号进行查询（）
     * @param sortIdTwo
     * @return （）书籍列表
     */
    public List<Book> findBysortIdTwo(int sortIdTwo);

    /**
     * 通过三级编号进行查询（）
     * @param sortIdThree
     * @return （）书籍列表
     */
    public List<Book> findBysortIdThree(int sortIdThree);

    /**
     * 更新单个书籍信息
     * @param book
     * @return 是否更新成功
     */
    public boolean update(Book book);

    /**
     * 增加一个书籍信息
     * @param bookId
     * @return 受影响的行数（书籍对象）
     */
    public int add(Book bookId);

    /**
     * 删除一个书籍信息
     * @param bookId
     * @return 受影响的行数
     */
    public int delete(int bookId);


    /**
     * 查询书籍统计
     * @return
     */
    public List<BookCharts> findStat();
}
