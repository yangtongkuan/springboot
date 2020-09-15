package com.stu.bean;

/**
 * Created with IntelliJ IDEA.
 *
 * @User: @Created by yangtk
 * @Date: @Date 2020/2/2 13:50
 * @To change this template use File | Settings | File Templates.
 */
public class Book {
    private String bookName;
    private String author;

    public Book(){}
    public Book(String bookName,String author){
        this.bookName = bookName;
        this.author = author;
    }
    public String getBookName() {
        return bookName;
    }

    public Book setBookName(String bookName) {
        this.bookName = bookName;
        return this;
    }

    public String getAuthor() {
        return author;
    }

    public Book setAuthor(String author) {
        this.author = author;
        return this;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookName='" + bookName + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
