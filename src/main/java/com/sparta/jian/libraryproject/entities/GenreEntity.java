package com.sparta.jian.libraryproject.entities;

import javax.persistence.*;

@Entity
@Table(name="genre", schema = "library")
@SequenceGenerator(name = "sequenceGenre", initialValue = 1, allocationSize = 1)
public class GenreEntity {

    @Id
    @GeneratedValue
    private Integer genreId;
    private String genreName;

    public GenreEntity(String genreName) {
        this.genreName = genreName;
    }

    public GenreEntity() {
    }

    @Id
    @Column(name = "genreId")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenre")
    public Integer getGenreId() {
        return genreId;
    }

    public void setGenreId(Integer genreId) {
        this.genreId = genreId;
    }

    @Basic
    @Column(name="genreName")
    public String getGenreName() {
        return genreName;
    }

    public void setGenreName(String genreName) {
        this.genreName = genreName;
    }
}
