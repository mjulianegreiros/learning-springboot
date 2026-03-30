package com.example.biblioteca.repositories;

import com.example.biblioteca.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    // TODO: implemente consulta para buscar autores por nacionalidade
    List<Author> findByNationality(String nationality);
}
