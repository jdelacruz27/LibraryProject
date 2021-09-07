package com.sparta.jian.libraryproject.controllers;

import com.sparta.jian.libraryproject.entities.BookEntity;
import com.sparta.jian.libraryproject.services.AuthorService;
import com.sparta.jian.libraryproject.services.BookService;
import com.sparta.jian.libraryproject.services.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BookController {

    private BookService bookService;
    private AuthorService authorService;
    private GenreService genreService;

    @Autowired
    public BookController(BookService bookService, AuthorService authorService, GenreService genreService) {
        this.bookService = bookService;
        this.authorService = authorService;
        this.genreService = genreService;
    }

    //fragment - objects
    @GetMapping("/bookPage")
    public String showBookPage(Model model, @Param("keyword") String keyword){

        if(keyword != null){
            keyword = keyword.replaceAll("\\s+", "%");
            model.addAttribute("books", bookService.findByKeyword(keyword));
            model.addAttribute("keyword", keyword.replaceAll("%", " "));
        } else {
            model.addAttribute("books", bookService.getAllBooksObjects());
        }
        return "bookPage";
    }

//    @GetMapping("/searchBook/{")
//    public String searchBook(@RequestParam(name = "keyword")String keyword, Model model){
//        keyword = keyword.replaceAll("\\s+", "%");
//        System.out.println(keyword);
//        model.addAttribute("books", bookService.findByKeyword(keyword));
//        model.addAttribute("keyword", keyword.replaceAll("%", " "));
//        return "bookPage";
//    }

    @GetMapping("/addBook")
    public String showAddBookPage(Model model){
        model.addAttribute("authors", authorService.getAllAuthorEntities());
        model.addAttribute("genres", genreService.getAllGenreEntities());
        return "addBook"
;    }


    @PostMapping("/addBook")
    public String addBook(@RequestParam(name = "isbnNumber") Integer isbn,
                          @RequestParam(name = "title") String title,
                          @RequestParam(name = "authorId") Integer author,
                          @RequestParam(name = "genreId") Integer genre){

        BookEntity bookEntity = new BookEntity();
        bookEntity.setIsbnNumber(isbn);
        bookEntity.setTitle(title);
        bookEntity.setAuthor(author);
        bookEntity.setGenre(genre);
        bookService.addBook(bookEntity);
        return "redirect:/bookPage";
    }



    @GetMapping("/editBook/{id}")
    public String editBook(@PathVariable("id") Integer id, Model model){
        model.addAttribute("book", bookService.findBookById(id));
        model.addAttribute("authors", authorService.getAllAuthorEntities());
        model.addAttribute("genres", genreService.getAllGenreEntities());
        return "editBook";
    }

    @PostMapping("/updateBook/{id}")
    public String updateBook(@PathVariable("id") Integer id,
                             @RequestParam(name = "isbnNumber") Integer isbn,
                             @RequestParam(name = "title") String title,
                             @RequestParam(name = "author") Integer author,
                             @RequestParam(name = "genre") Integer genre) {

        BookEntity bookEntity = new BookEntity();
        bookEntity.setBookId(id);
        bookEntity.setIsbnNumber(isbn);
        bookEntity.setTitle(title);
        bookEntity.setAuthor(author);
        bookEntity.setGenre(genre);
        bookService.addBook(bookEntity);
        return "redirect:/bookPage";
    }

    @GetMapping("/deleteBook/{id}")
    public String deleteBook(@PathVariable("id") Integer id, Model model){
        bookService.deleteBook(id);
        return "redirect:/bookPage";
    }
}
