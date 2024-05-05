package com.book.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.model.Book;
import com.book.repository.BookRepository;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    public List<Book> allBook() {
        return (List<Book>) bookRepository.findAll();
    }

    public Book editBook(String id, Book book) {
        Optional<Book> res = bookRepository.findById(id);
        if (res.isPresent()) {
            Book retBook = res.get();
            retBook.setId(book.getId());
            retBook.setName(book.getName());
            retBook.setAuthor(book.getAuthor());
            retBook.setGenres(book.getGenres());
            retBook.setPrice(book.getPrice());
            return bookRepository.save(retBook);
        } else {
            return null;
        }

    }
}
