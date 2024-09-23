package com.example.libraryservice.entity;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Book {
    private int bookId;
    private String personId;
    private String name;
    private String author;
}
