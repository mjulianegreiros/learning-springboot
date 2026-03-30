package com.example.biblioteca.services;

import com.example.biblioteca.repositories.BookRepository;
import com.example.biblioteca.entities.Book;
import com.example.biblioteca.entities.Author;
import com.example.biblioteca.repositories.AuthorRepository;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class LibraryService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public LibraryService(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    public List<Author> buscarPorNacionalidade(String authorNationality){
        return authorRepository.findByNationality(authorNationality);
    }
    
    public List<Book> buscarPorPalavraChave(String palavraChave){
        return bookRepository.findByTitleContaining(palavraChave);
    }
    public List<Book> buscarPorAnoPublicacao(Integer ano){
        return bookRepository.findByPublicationYear(ano);
    }
    public List<Book> buscarPorNomeAutor(String nomeAutor){
        return bookRepository.findByAuthorName(nomeAutor);
    }
}
