package com.sparta.jian.libraryproject.repositories;

import com.sparta.jian.libraryproject.entities.GenreEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GenreRepository extends JpaRepository<GenreEntity, Integer> {

    @Query(value="SELECT * FROM genre", nativeQuery = true)
    List<GenreEntity> getAllGenreEntities();
}
