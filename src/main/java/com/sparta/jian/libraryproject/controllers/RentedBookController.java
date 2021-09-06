package com.sparta.jian.libraryproject.controllers;


import com.sparta.jian.libraryproject.entities.BookEntity;
import com.sparta.jian.libraryproject.entities.RentedBookEntity;
import com.sparta.jian.libraryproject.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@Controller
public class RentedBookController {
    private RentedBookService rentedBookService;
    private AuthorService authorService;
    private GenreService genreService;
    private BookService bookService;
    private UserService userService;

    @Autowired
    public RentedBookController(RentedBookService rentedBookService, AuthorService authorService, GenreService genreService, BookService bookService, UserService userService) {
        this.rentedBookService = rentedBookService;
        this.authorService = authorService;
        this.genreService = genreService;
        this.bookService = bookService;
        this.userService = userService;
    }

    @GetMapping("/rent")
    public String showRentPage(Model model) {
        model.addAttribute("books", bookService.getAllBooksObjects());
        return "rentBookPage";
    }

    @GetMapping("/rentBook/{id}")
    public String rentBook(@PathVariable("id") Integer id, BookEntity bookEntity, RentedBookEntity rental, Authentication authentication){
        bookEntity = bookService.findBookById(id);
        rental.setBookId(bookEntity.getBookId());
        rental.setIsbnNumber(bookEntity.getIsbnNumber());
        rental.setTitle(bookEntity.getTitle());
        rental.setAuthor(bookEntity.getAuthor());
        rental.setGenre(bookEntity.getGenre());
        rental.setUser(userService.findUserIdByName(authentication.getName()));
        rentedBookService.addBook(rental);
        bookService.deleteBook(id);
        return "redirect:/rent";
    }


    @GetMapping("/bookBag")
    public String showBookBag(Model model, Authentication authentication){
        model.addAttribute("rentals", rentedBookService.getAllRentedBooksByUser(userService.findUserIdByName(authentication.getName())));
        return "bookBagPage";
    }

    @GetMapping("/return/{id}")
    public String returnBook(@PathVariable("id") Integer id, RentedBookEntity rental, BookEntity bookEntity){
        rental = rentedBookService.findBookById(id);
        bookEntity.setBookId(id);
        bookEntity.setIsbnNumber(rental.getIsbnNumber());
        bookEntity.setTitle(rental.getTitle());
        bookEntity.setAuthor(rental.getAuthor());
        bookEntity.setGenre(rental.getGenre());
        bookService.addBook(bookEntity);
        rentedBookService.returnBook(id);
        return "redirect:/bookBag";
    }

//    @GetMapping("/return/{id}")
//    public String checkReturn(@PathVariable ("id") Integer id,  Model model){
//        model.addAttribute("book", rentedBookService.findBookById(id));
//        model.addAttribute("authors", authorService.getAllAuthorEntities());
//        model.addAttribute("genres", genreService.getAllGenreEntities());
//        return "checkReturnPage";
//    }
//
//
//    @PostMapping("/returnBook/{id}")
//    public String returnBook(@PathVariable("id") Integer id,
//                             @RequestParam(name = "isbnNumber") Integer isbn,
//                             @RequestParam(name = "title") String title,
//                             @RequestParam(name = "author") Integer author,
//                             @RequestParam(name = "genre") Integer genre){
//
//        BookEntity bookEntity = new BookEntity();
//        bookEntity.setBookId(id);
//        bookEntity.setIsbnNumber(isbn);
//        bookEntity.setTitle(title);
//        bookEntity.setAuthor(author);
//        bookEntity.setGenre(genre);
//        bookService.addBook(bookEntity);
//        rentedBookService.returnBook(id);
//        return "redirect:/bookBag";
//    }



}
