package com.etc.service;

import com.etc.pojo.Chapters;

import java.util.List;

/**
 * @author hrf
 * 书籍章节的业务逻辑接口
 */
public interface ChaptersService {
    /**
     * 查看所有书籍章节列表
     * @return 章节列表
     */
    public List<Chapters> findAll();

    /**
     * 通过书籍id查找书籍章节
     * @return 书籍章节列表
     */
    public List<Chapters> findByBookId(int bookId);

    /**
     * 通过书籍章节编号查找书籍章节对象
     * @param chaptersId
     * @return 书籍章节对象
     */
    public Chapters findByChaptersId(int chaptersId);

    /**
     * 增加一个书籍章节对象
     * @param chapters
     * @return 受影响的行数
     */
    public int add(Chapters chapters);

    /**
     * 修改一个书籍对象
     * @param chapters
     * @return 受影响的行数
     */
    public int update(Chapters chapters);

    /**
     * 删除一个章节对象
     * @param chaptersId
     * @return 受影响的行数
     */
    public int delete(int chaptersId);
}
