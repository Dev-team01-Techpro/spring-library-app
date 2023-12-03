package com.janavar.controller;

import com.janavar.domain.Book;
import com.janavar.dto.BookDTO;
import com.janavar.service.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping // http://localhost:8080/books
    public ResponseEntity<List<Book>> listAllBooks(){
       List<Book> bookList= bookService.listAllBooks();
        return ResponseEntity.ok(bookList);
    }

    @GetMapping("/{id}") // http://localhost:8080/books/1
    public ResponseEntity<Book> getBookById(@PathVariable("id") Long id ){
      return ResponseEntity.ok(bookService.findById(id));
    }

    @PostMapping  // http://localhost:8080/books  Post + Json
    public ResponseEntity<Map<String, String>> createBook(@Valid @RequestBody BookDTO bookDTO){

        //Book classtan BookDTO yaptık

        bookService.createBook(bookDTO);
        Map<String,String> messages = new HashMap<>();
        messages.put("message", "Kitap olusturma islemi basarili");
        messages.put("status","true");
        return new ResponseEntity<>(messages, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}") //http://localhost:8080/books/delete/1
    public ResponseEntity<String> deleteBook(@PathVariable("id") Long id){
        bookService.deleteBook(id);
        String message="Book deleted successfully";
        return new ResponseEntity<>(message,HttpStatus.OK);
        //return ResponseEntity.ok(message);
    }

    @PutMapping("/query") //http://localhost:8080/query?id=1 + PUT + JSON
    public ResponseEntity<String> updateById(@RequestParam("id") Long id,
                                             @Valid @RequestBody BookDTO bookDTO){
        bookService.updateById(id,bookDTO);
        String message = "Kayıt başarılı";

        return ResponseEntity.ok(message);
    }

}
