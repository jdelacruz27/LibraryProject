package com.sparta.jian.libraryproject.controllers;

import com.sparta.jian.libraryproject.entities.AuthorEntity;
import com.sparta.jian.libraryproject.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class AuthorController {

    private AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("/authorPage")
    public String authorPage(Model model){
        model.addAttribute("authors", authorService.getAllAuthors());
        return "authorPage";
    }

    @GetMapping("/addAuthor")
    public String showAddAuthorPage(){
        return "addAuthor";
    }

    @PostMapping("/addAuthor")
    public String addAuthor(@RequestParam(name = "forename") String forename,
                            @RequestParam(name = "surname") String surname){
        AuthorEntity authorEntity = new AuthorEntity();
        authorEntity.setForename(forename);
        authorEntity.setSurname(surname);
        authorService.addAuthor(authorEntity);
        return "redirect:/authorPage";
    }

    @GetMapping("/editAuthor/{id}")
    public String editAuthor(@PathVariable("id") Integer id, Model model){
        model.addAttribute("author", authorService.findAuthorById(id));
        return "editAuthor";
    }

    @PostMapping("/updateAuthor/{id}")
    public String updateAuthor(@PathVariable("id") Integer id, AuthorEntity authorEntity) {
        authorEntity.setAuthorId(id);
        authorService.addAuthor(authorEntity);
        return "redirect:/authorPage";
    }

    @GetMapping("/deleteAuthor/{id}")
    public String deleteAuthor(@PathVariable("id") Integer id){
        authorService.deleteAuthor(id);
        return "redirect:/authorPage";
    }

}
