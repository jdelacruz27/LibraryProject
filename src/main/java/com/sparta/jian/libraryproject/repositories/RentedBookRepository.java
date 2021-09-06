package com.sparta.jian.libraryproject.repositories;

import com.sparta.jian.libraryproject.entities.RentedBookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RentedBookRepository extends JpaRepository<RentedBookEntity, Integer> {

    @Query(value = "SELECT rb.isbn_number, rb.title, a.forename, a.surname, g.genre_name, b.book_id " +
            "FROM rented_book rb INNER JOIN author a " +
            "ON rb.author_id = a.author_id " +
            "INNER JOIN genre g " +
            "ON rb.genre_id = g.genre_id " +
            "GROUP BY book_id " +
            "ORDER BY a.author_id", nativeQuery = true)
    List<Object[]> getAllRentedBooksByArray();

    @Query(value = "SELECT rb.isbn_number, rb.title, a.forename, a.surname, g.genre_name, rb.book_id " +
            "FROM rented_book rb INNER JOIN author a " +
            "ON rb.author_id = a.author_id " +
            "INNER JOIN genre g " +
            "ON rb.genre_id = g.genre_id " +
            "INNER JOIN user_entity u " +
            "ON rb.user_id = u.user_id " +
            "WHERE rb.user_id = ?1" ,nativeQuery = true)
    List<Object[]> getAllRentedBooksByUser(Integer id);
}
