package com.book.model;

import lombok.Data;

@Data
public class Book {
    private String id;
    private String name;
    private String author;
    private String genres;
    private String price;
}
