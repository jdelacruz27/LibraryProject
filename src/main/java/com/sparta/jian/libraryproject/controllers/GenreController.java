package com.sparta.jian.libraryproject.controllers;

import com.sparta.jian.libraryproject.entities.GenreEntity;
import com.sparta.jian.libraryproject.services.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GenreController {

    private GenreService genreService;

    @Autowired
    public GenreController(GenreService genreService) {
        this.genreService = genreService;
    }

    @GetMapping("/genrePage")
    public String genrePage(Model model){
        model.addAttribute("genres", genreService.getAllGenres());
        return "genrePage";
    }

    @GetMapping("/addGenre")
    public String showAddGenrePage(){
        return "addGenre";
    }

    @PostMapping("/addGenre")
    public String addGenre(@RequestParam(name = "genreName") String genreName){
        GenreEntity genreEntity = new GenreEntity();
        genreEntity.setGenreName(genreName);
        genreService.addGenre(genreEntity);
        return "redirect:/genrePage";
    }

    @GetMapping("/editGenre/{id}")
    public String editGenre(@PathVariable("id") Integer id, Model model){
        model.addAttribute("genre", genreService.findGenreById(id));
        return "editGenre";
    }

    @PostMapping("/updateGenre/{id}")
    public String updateGenre(@PathVariable("id") Integer id, GenreEntity genreEntity){
        genreEntity.setGenreId(id);
        genreService.addGenre(genreEntity);
        return "redirect:/genrePage";
    }

    @GetMapping("/deleteGenre/{id}")
    public String deleteGenre(@PathVariable("id") Integer id, Model model){
        genreService.deleteGenre(id);
        return "redirect:/genrePage";
    }
}
