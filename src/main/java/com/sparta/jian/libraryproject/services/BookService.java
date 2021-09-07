package com.sparta.jian.libraryproject.services;

import com.sparta.jian.libraryproject.entities.BookEntity;
import com.sparta.jian.libraryproject.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    private BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

//    public Iterable<BookEntity> getAllBooks(){
//        return bookRepository.findAll();
//    }

    public List<Object[]> getAllBooksObjects(){
        return bookRepository.getAllBooksByArray();
    }

    public List<BookEntity> getAllBookEntities(){
        return bookRepository.getAllBookEntities();
    }

    public void addBook(BookEntity bookEntity){
        bookRepository.save(bookEntity);
    }

    public void deleteBook(Integer id){
        bookRepository.deleteById(id);
    }

    public BookEntity findBookById(Integer id){
        return bookRepository.findById(id).orElseThrow(
                ()-> new IllegalArgumentException("Invalid ID" + id)
        );
    }

    public List<Object[]> findByKeyword(String keyword){
        return bookRepository.findByKeyword(keyword);
    }


}
