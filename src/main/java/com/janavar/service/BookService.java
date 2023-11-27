package com.janavar.service;

import com.janavar.domain.Book;
import com.janavar.exception.ResourceNotFoundException;
import com.janavar.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> listAllBooks() {
        return bookRepository.findAll();
    }

    public Book findById(Long id) {
        return bookRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Book not found by this id: " + id));
    }

    public void createBook(Book book) {
        bookRepository.save(book);
    }


}
