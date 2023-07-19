package com.etc.vo;

/**
 * @author hrf
 * 书架vo
 */
public class BookrackVO {
    /**
     * 书架编号
     */
    private int bookrackId;

    /**
     *人员编号
     */
    private int userId;

    /**
     * 书籍编号
     */
    private int bookId;

    /**
     * 章节编号
     */
    private int chaptersId;

    public BookrackVO() {
    }

    public BookrackVO(int bookrackId, int userId, int bookId, int chaptersId) {
        this.bookrackId = bookrackId;
        this.userId = userId;
        this.bookId = bookId;
        this.chaptersId = chaptersId;
    }

    @Override
    public String toString() {
        return "BookrackVO{" +
                "bookrackId=" + bookrackId +
                ", userId=" + userId +
                ", bookId=" + bookId +
                ", chaptersId=" + chaptersId +
                '}';
    }

    public int getBookrackId() {
        return bookrackId;
    }

    public void setBookrackId(int bookrackId) {
        this.bookrackId = bookrackId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getChaptersId() {
        return chaptersId;
    }

    public void setChaptersId(int chaptersId) {
        this.chaptersId = chaptersId;
    }
}
