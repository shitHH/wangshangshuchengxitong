package com.etc.pojo;

/**
 * @author zwh
 * @date 2021/11/17
 * 书籍类
 */
public class Book {

    /**
     * 书籍编号
     */
    private int bookId;

    /**
     * 书籍名称
     */
    private String bookName;

    /**
     * 类型1级编号
     */
    private int sortIdOne;

    /**
     * 类型2级编号
     */
    private int sortIdTwo;

    /**
     * 类型3级编号
     */
    private int sortIdThree;

    /**
     * 上传人编号
     */
    private int userId;

    /**
     * 作者姓名
     */
    private String bookAuthor;

    /**
     * 书籍简介
     */
    private String bookBrief;

    /**
     * 书籍状态（1免费、2会员免费、3付费、4下架）
     */
    private int bookStats;

    /**
     * 照片地址
     */
    private String photo;

    public Book() {
    }

    public Book(int bookId, String bookName, int sortIdOne, int sortIdTwo, int sortIdThree, int userId, String bookAuthor, String bookBrief, int bookStats, String photo) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.sortIdOne = sortIdOne;
        this.sortIdTwo = sortIdTwo;
        this.sortIdThree = sortIdThree;
        this.userId = userId;
        this.bookAuthor = bookAuthor;
        this.bookBrief = bookBrief;
        this.bookStats = bookStats;
        this.photo = photo;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", bookName='" + bookName + '\'' +
                ", sortIdOne=" + sortIdOne +
                ", sortIdTwo=" + sortIdTwo +
                ", sortIdThree=" + sortIdThree +
                ", userId=" + userId +
                ", bookAuthor='" + bookAuthor + '\'' +
                ", bookBrief='" + bookBrief + '\'' +
                ", bookStats=" + bookStats +
                ", photo='" + photo + '\'' +
                '}';
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getSortIdOne() {
        return sortIdOne;
    }

    public void setSortIdOne(int sortIdOne) {
        this.sortIdOne = sortIdOne;
    }

    public int getSortIdTwo() {
        return sortIdTwo;
    }

    public void setSortIdTwo(int sortIdTwo) {
        this.sortIdTwo = sortIdTwo;
    }

    public int getSortIdThree() {
        return sortIdThree;
    }

    public void setSortIdThree(int sortIdThree) {
        this.sortIdThree = sortIdThree;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public String getBookBrief() {
        return bookBrief;
    }

    public void setBookBrief(String bookBrief) {
        this.bookBrief = bookBrief;
    }

    public int getBookStats() {
        return bookStats;
    }

    public void setBookStats(int bookStats) {
        this.bookStats = bookStats;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
