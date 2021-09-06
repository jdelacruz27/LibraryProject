package com.sparta.jian.libraryproject.entities;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "book", schema = "library")
@SequenceGenerator(name = "sequenceBook", initialValue = 1, allocationSize = 1)
public class BookEntity {

    @Id
    @GeneratedValue
    private Integer bookId;
    private Integer isbnNumber;
    private String title;
    private Integer authorId;
    private Integer genreId;


    //    @ManyToMany
    //    private Set<GenreEntity> genreList = new HashSet<>();

    public BookEntity(Integer isbnNumber, String title, Integer author, Integer genre) {
        this.isbnNumber = isbnNumber;
        this.title = title;
        this.authorId = author;
        this.genreId = genre;
    }

    public BookEntity(){

    }

    @Id
    @Column(name = "bookId")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceBook")
    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer id) {
        this.bookId = id;
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

    public void setAuthor(Integer author) {
        this.authorId = author;
    }

    @Basic
    @Column(name="genreId")
    public Integer getGenre() {
        return genreId;
    }

    public void setGenre(Integer genre) {
        this.genreId = genre;
    }
}
