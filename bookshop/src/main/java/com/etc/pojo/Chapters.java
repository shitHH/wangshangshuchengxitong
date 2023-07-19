package com.etc.pojo;

import java.lang.ref.PhantomReference;

/**
 * @author zwh
 * @date 2021/11/17
 * 章节类
 */
public class Chapters {

    /**
     * 章节编号
     */
    private int chaptersId;

    /**
     * 书籍编号
     */
    private int bookId;

    /**
     * 章节名称
     */
    private String chaptersName;

    /**
     * 章节内容
     */
    private String chaptersText;

    /**
     * 章节状态 0：草稿1 审核2：发布
     */
    private int chaptersType;

    /**
     * 章节 押金（根据字数算）
     */
    private double chaptersPrice;


    /**
     * 书籍对象
     */
    private Book book;

    public Chapters() {
    }

    public Chapters(int chaptersId, int bookId, String chaptersName, String chaptersText, int chaptersType, double chaptersPrice, Book book) {
        this.chaptersId = chaptersId;
        this.bookId = bookId;
        this.chaptersName = chaptersName;
        this.chaptersText = chaptersText;
        this.chaptersType = chaptersType;
        this.chaptersPrice = chaptersPrice;
        this.book = book;
    }

    @Override
    public String toString() {
        return "Chapters{" +
                "chaptersId=" + chaptersId +
                ", bookId=" + bookId +
                ", chaptersName='" + chaptersName + '\'' +
                ", chaptersText='" + chaptersText + '\'' +
                ", chaptersType=" + chaptersType +
                ", chaptersPrice=" + chaptersPrice +
                ", book=" + book +
                '}';
    }

    public int getChaptersId() {
        return chaptersId;
    }

    public void setChaptersId(int chaptersId) {
        this.chaptersId = chaptersId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getChaptersName() {
        return chaptersName;
    }

    public void setChaptersName(String chaptersName) {
        this.chaptersName = chaptersName;
    }

    public String getChaptersText() {
        return chaptersText;
    }

    public void setChaptersText(String chaptersText) {
        this.chaptersText = chaptersText;
    }

    public int getChaptersType() {
        return chaptersType;
    }

    public void setChaptersType(int chaptersType) {
        this.chaptersType = chaptersType;
    }

    public double getChaptersPrice() {
        return chaptersPrice;
    }

    public void setChaptersPrice(double chaptersPrice) {
        this.chaptersPrice = chaptersPrice;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
