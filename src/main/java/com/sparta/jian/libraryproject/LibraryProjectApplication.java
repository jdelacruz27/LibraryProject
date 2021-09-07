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

//            userService.addUser(new UserEntity("admin", encoder.encode("password"), "ADMIN", 1 ));
//            userService.addUser(new UserEntity("user", encoder.encode("password"), "USER", 1 ));

        };

    }
}
