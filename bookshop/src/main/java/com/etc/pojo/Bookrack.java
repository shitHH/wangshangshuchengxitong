package com.etc.pojo;

/**
 * @author zwh
 * @date 2021/11/17
 * 书架类
 */
public class Bookrack {
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

    /**
     * 书籍名称
     */
    private String bookName;

    /**
     * 作者姓名
     */
    private String bookAuthor;

    /**
     * 照片地址
     */
    private String photo;

    public Bookrack() {
    }

    public Bookrack(int bookrackId, int userId, int bookId, int chaptersId, String bookName, String bookAuthor, String photo) {
        this.bookrackId = bookrackId;
        this.userId = userId;
        this.bookId = bookId;
        this.chaptersId = chaptersId;
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
        this.photo = photo;
    }

    @Override
    public String toString() {
        return "Bookrack{" +
                "bookrackId=" + bookrackId +
                ", userId=" + userId +
                ", bookId=" + bookId +
                ", chaptersId=" + chaptersId +
                ", bookName='" + bookName + '\'' +
                ", bookAuthor='" + bookAuthor + '\'' +
                ", photo='" + photo + '\'' +
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

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
