package com.example.biblioteca.entities;

import jakarta.persistence.*;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private Integer publicationYear;
    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

    public Long getId(){
        return this.id;
    }
    public String getTitle(){
        return this.title;
    }
    public Integer getPublicationYear(){
        return this.publicationYear;
    }
    public Author getAuthor(){
        return this.author;
    }

    public void setTitle(String title){
        this.title = title;
    }
    public void setPublicationYear(Integer publicationYear){
        this.publicationYear = publicationYear;
    }
    public void setAuthor(Author author){
        this.author = author;
    }


}
