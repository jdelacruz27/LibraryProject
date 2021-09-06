package com.sparta.jian.libraryproject.entities;

import javax.persistence.*;

@Entity
@Table(name="rentedBook", schema = "library")
public class RentedBookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceBook")
    private Integer bookId;
    private Integer isbnNumber;
    private String title;
    private Integer authorId;
    private Integer genreId;
    private Integer userId;

    public RentedBookEntity(Integer isbnNumber, String title, Integer author, Integer genre, Integer userId) {
        this.isbnNumber = isbnNumber;
        this.title = title;
        this.authorId = author;
        this.genreId = genre;
        this.userId = userId;
    }

    public RentedBookEntity(){

    }

    @Id
    public Integer getBookId() {
        return bookId;
    }


    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }
    @Basic
    @Column(name="isbnNumber")
    public Integer getIsbnNumber() {
        return isbnNumber;
    }

    public void setIsbnNumber(Integer isbnNumber) {
        this.isbnNumber = isbnNumber;
    }

    @Basic
    @Column(name="title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name="authorId")
    public Integer getAuthor() {
        return authorId;
    }

    public void setAuthor(Integer authorId) {
        this.authorId = authorId;
    }

    @Basic
    @Column(name="genreId")
    public Integer getGenre() {
        return genreId;
    }

    public void setGenre(Integer genreId) {
        this.genreId = genreId;
    }

    @Basic
    @Column(name="userId")
    public Integer getUser() {
        return userId;
    }

    public void setUser(Integer userId) {
        this.userId = userId;
    }
}
