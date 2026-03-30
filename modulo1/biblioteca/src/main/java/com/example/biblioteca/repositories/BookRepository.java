package com.example.biblioteca.repositories;

import com.example.biblioteca.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    // TODO: implemente consulta para buscar livros por título contendo palavra-chave
    List<Book> findByTitleContaining(String keyword);

    // TODO: implemente consulta para buscar livros por ano de publicação
    List<Book> findByPublicationYear(Integer year);

    // TODO: implemente consulta para listar todos os livros de um determinado autor
    List<Book> findByAuthorName(String name);
}
