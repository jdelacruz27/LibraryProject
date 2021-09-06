package com.sparta.jian.libraryproject.repositories;

import com.sparta.jian.libraryproject.entities.AuthorEntity;
import com.sparta.jian.libraryproject.entities.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<AuthorEntity, Integer> {

    @Query(value="SELECT * FROM author", nativeQuery = true)
    List<AuthorEntity> getAllAuthorEntities();
}
