package com.sparta.jian.libraryproject.services;

import com.sparta.jian.libraryproject.entities.AuthorEntity;
import com.sparta.jian.libraryproject.entities.GenreEntity;
import com.sparta.jian.libraryproject.repositories.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreService {
    private GenreRepository genreRepository;

    @Autowired
    public GenreService(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    public Iterable<GenreEntity>getAllGenres(){
        return genreRepository.findAll();
    }

    public List<GenreEntity> getAllGenreEntities(){
        return genreRepository.getAllGenreEntities();
    }

    public void addGenre(GenreEntity genreEntity){
        genreRepository.save(genreEntity);
    }

    public void deleteGenre(Integer id){
        genreRepository.deleteById(id);
    }

    public GenreEntity findGenreById(Integer id){
        return genreRepository.findById(id).orElseThrow(
                ()-> new IllegalArgumentException("Invalid ID" + id)
        );
    }
}
