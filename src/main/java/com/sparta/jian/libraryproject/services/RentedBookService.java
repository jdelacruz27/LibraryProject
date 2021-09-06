package com.sparta.jian.libraryproject.services;

import com.sparta.jian.libraryproject.entities.BookEntity;
import com.sparta.jian.libraryproject.entities.RentedBookEntity;
import com.sparta.jian.libraryproject.repositories.RentedBookRepository;
import com.sparta.jian.libraryproject.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
public class RentedBookService {
    private RentedBookRepository rentedBookRepository;
    private UserRepository userRepository;


    @Autowired
    public RentedBookService(RentedBookRepository rentedBookRepository) {
        this.rentedBookRepository = rentedBookRepository;
    }

    public List<Object[]> getAllRentedBooksObjects(){
        return rentedBookRepository.getAllRentedBooksByArray();
    }

    public List<Object[]> getAllRentedBooksByUser(Integer id){
        return rentedBookRepository.getAllRentedBooksByUser(id);

    }

    public void addBook(RentedBookEntity rentedBookEntity){
        rentedBookRepository.save(rentedBookEntity);
    }

    public void returnBook(Integer id){
        rentedBookRepository.deleteById(id);
    }

    public RentedBookEntity findBookById(Integer id){
        return rentedBookRepository.findById(id).orElseThrow(
                ()-> new IllegalArgumentException("Invalid ID" + id)
        );
    }

}
