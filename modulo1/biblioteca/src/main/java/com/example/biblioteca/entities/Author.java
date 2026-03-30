package com.example.biblioteca.entities;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String nationality;
    @OneToMany(mappedBy = "author")
    private List<Book> book;

    public Long getId(){
        return this.id;
    }
    public String getName(){
        return this.name;
    }
    public String getNationality(){
        return this.nationality;
    }
    public List<Book> getBook(){
        return this.book;
    }

    public void setName(String name){
        this.name = name;
    }
    public void setNationality(String nationality){
        this.nationality = nationality;
    }
    public void setBook(List<Book> book){
        this.book = book;
    }

}
