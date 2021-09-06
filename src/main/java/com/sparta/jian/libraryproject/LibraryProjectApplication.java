package com.sparta.jian.libraryproject;

import com.sparta.jian.libraryproject.entities.AuthorEntity;
import com.sparta.jian.libraryproject.entities.GenreEntity;
import com.sparta.jian.libraryproject.entities.UserEntity;
import com.sparta.jian.libraryproject.services.AuthorService;
import com.sparta.jian.libraryproject.services.GenreService;
import com.sparta.jian.libraryproject.services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class LibraryProjectApplication {

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public static void main(String[] args) {
        SpringApplication.run(LibraryProjectApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(GenreService genreService, AuthorService authorService, UserService userService) {
        return (args) -> {
//            genreService.addGenre(new GenreEntity("Thriller"));
//            genreService.addGenre(new GenreEntity("Horror"));
//            genreService.addGenre(new GenreEntity("Fiction"));
//            genreService.addGenre(new GenreEntity("Sci-Fi"));
//            genreService.addGenre(new GenreEntity("Romance"));
//            genreService.addGenre(new GenreEntity("Fantasy"));
//            genreService.addGenre(new GenreEntity("Mystery"));
//            genreService.addGenre(new GenreEntity("Crime"));
//            genreService.addGenre(new GenreEntity("Drama"));
//            genreService.addGenre(new GenreEntity("Children"));
//            authorService.addAuthor(new AuthorEntity("George R.R", "Martin"));
//            authorService.addAuthor(new AuthorEntity("J.K","Rowling"));
//            authorService.addAuthor(new AuthorEntity("Paulo","Coelho"));
//            authorService.addAuthor(new AuthorEntity("Stephen","King"));
//            authorService.addAuthor(new AuthorEntity("Dr.","Seuss"));
//            authorService.addAuthor(new AuthorEntity("John","Green"));
//            userService.addUser(new UserEntity("jian", encoder.encode("password"), "ADMIN", 1 ));
//            userService.addUser(new UserEntity("jiji", encoder.encode("password"), "USER", 1 ));

        };

    }
}
