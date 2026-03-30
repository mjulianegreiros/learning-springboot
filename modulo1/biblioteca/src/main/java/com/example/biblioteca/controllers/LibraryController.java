package com.example.biblioteca.controllers;

import java.util.List;

import org.apache.tomcat.jni.Library;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.biblioteca.entities.Author;
import com.example.biblioteca.entities.Book;
import com.example.biblioteca.services.LibraryService;

@RestController
@RequestMapping("/api")
public class LibraryController {
    private final LibraryService libraryService;

    public LibraryController(LibraryService libraryService){
        this.libraryService = libraryService;
    }

    @GetMapping("/authors/nationality/{nationality}")
    public List<Author> getAuthorsByNationality(@PathVariable String nationality){
        return libraryService.buscarPorNacionalidade(nationality);
    }

    @GetMapping("/books/title/{keyWord}")
    public List<Book> getBookByKeyWord(@PathVariable String keyWord){
        return libraryService.buscarPorPalavraChave(keyWord);
    }
    @GetMapping("/books/year/{year}")
    public List<Book> getBookByPublicationYear(@PathVariable Integer year){
        return libraryService.buscarPorAnoPublicacao(year);
    }
    @GetMapping("/books/author/{author}")
    public List<Book> getBookByAuthor(@PathVariable String author){
        return libraryService.buscarPorNomeAutor(author);
    }
}
