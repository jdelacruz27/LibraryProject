package com.sparta.jian.libraryproject.services;

import com.sparta.jian.libraryproject.entities.AuthorEntity;
import com.sparta.jian.libraryproject.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {
    private AuthorRepository authorRepository;

    @Autowired
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Iterable<AuthorEntity> getAllAuthors(){
        return authorRepository.findAll();
    }

    public List<AuthorEntity> getAllAuthorEntities(){
        return authorRepository.getAllAuthorEntities();
    }

    public void addAuthor(AuthorEntity authorEntity){
        authorRepository.save(authorEntity);
    }

    public void deleteAuthor(Integer id){
        authorRepository.deleteById(id);
    }

    public AuthorEntity findAuthorById(Integer id){
        return authorRepository.findById(id).orElseThrow(
                ()-> new IllegalArgumentException("Invalid ID" + id)
        );
    }
}
