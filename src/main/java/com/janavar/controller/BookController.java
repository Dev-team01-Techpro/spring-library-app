package com.janavar.controller;

import com.janavar.domain.Book;
import com.janavar.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    //public ResponseEntity<List> listAllBooks()
    //http://localhost:8080/books
    @GetMapping
    public ResponseEntity<List<Book>> listAllBooks(){
       List<Book> bookList= bookService.listAllBooks();
        return ResponseEntity.ok(bookList);
    }

   //public ResponseEntity getBookById(@PathVariable("id") Long id)
    //http://localhost:8080/books/1
    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable("id") Long id ){
      return ResponseEntity.ok(bookService.findById(id));
    }
}
