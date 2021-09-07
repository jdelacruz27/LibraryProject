package com.sparta.jian.libraryproject.entities;



import javax.persistence.*;

@Entity
@Table(name = "author", schema = "library")
@SequenceGenerator(name = "sequenceGenre", initialValue = 1, allocationSize = 1)
public class AuthorEntity {

    @Id
    @GeneratedValue
    private Integer authorId;
    private String forename;
    private String surname;



    public AuthorEntity(String forename, String surname) {
        this.forename = forename;
        this.surname = surname;
    }

    public AuthorEntity() {
    }

    @Id
    @Column(name="author_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceCourse")
    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    @Basic
    @Column(name="forename")
    public String getForename() {
        return forename;
    }

    public void setForename(String forename) {
        this.forename = forename;
    }

    @Basic
    @Column(name="surname")
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

}
