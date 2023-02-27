package elab.spring.leraningSpring.controllers;

import elab.spring.leraningSpring.repositories.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {

    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @RequestMapping("/books") // quando arriva questa richiesta viene eseguito questo metodo
    public String getBooks(Model model){
        model.addAttribute("books", bookRepository.findAll()); //nel model avremo un attributo book con tutti i book della repository

        return "books/list"; // cercare il template list nella directory books (??)
    }
}
