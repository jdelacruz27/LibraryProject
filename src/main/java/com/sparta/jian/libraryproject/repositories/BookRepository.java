package com.sparta.jian.libraryproject.repositories;

import com.sparta.jian.libraryproject.entities.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.awt.print.Book;
import java.util.List;


@Repository
public interface BookRepository extends JpaRepository <BookEntity, Integer> {

    @Query(value = "SELECT b.isbn_number, b.title, a.forename, a.surname, g.genre_name, b.book_id " +
            "FROM book b INNER JOIN author a " +
            "ON b.author_id = a.author_id " +
            "INNER JOIN genre g " +
            "ON b.genre_id = g.genre_id " +
            "GROUP BY book_id " +
            "ORDER BY a.author_id", nativeQuery = true)
    List<Object[]> getAllBooksByArray();

    @Query(value="SELECT * FROM book", nativeQuery = true)
    List<BookEntity> getAllBookEntities();

    @Query(value = "SELECT b.isbn_number, b.title, a.forename, a.surname, g.genre_name, b.book_id " +
            "FROM book b INNER JOIN author a " +
            "ON b.author_id = a.author_id " +
            "INNER JOIN genre g " +
            "ON b.genre_id = g.genre_id " +
            "WHERE b.title LIKE %?1% OR a.forename LIKE %?1% " +
            "OR a.surname LIKE %?1% OR g.genre_name LIKE %?1%", nativeQuery = true)
    List<BookEntity> findByKeyword(/*@Param("keyword")*/ String keyword);
}
