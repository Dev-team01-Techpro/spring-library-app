package com.janavar.service;

import com.janavar.domain.Book;
import com.janavar.domain.Member;
import com.janavar.dto.BookDTO;
import com.janavar.exception.ResourceNotFoundException;
import com.janavar.repository.BookRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private MemberService memberService;

    public List<Book> listAllBooks() {
        return bookRepository.findAll();
    }

    public Book findById(Long id) {
        return bookRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Book not found by this id: " + id));
    }

    public void createBook(@Valid BookDTO bookDTO) {

        Book book = new Book();
        Member member=memberService.getMemberId(1L);


        book.setBookName(bookDTO.getBookName());
        book.setType(bookDTO.getType());
        book.setAuthor(bookDTO.getAuthor());
        book.setPublishYear(bookDTO.getPublishYear());
        book.setPageNumber(bookDTO.getPageNumber());
        book.setMember(member);



        //todo : Kütüphane adında Member oluşturup, atanmamış kitaplar ı kütüphane kullanıcısına atayacağız.

        bookRepository.save(book);
    }

    public void deleteBook(Long id) {
        Book book = findById(id);
        bookRepository.delete(book);
    }

    public void updateById(Long id, BookDTO bookDTO) {

        Book book = findById(id);

        book.setBookName(bookDTO.getBookName());
        book.setType(bookDTO.getType());
        book.setAuthor(bookDTO.getAuthor());
        book.setPublishYear(bookDTO.getPublishYear());
        book.setPageNumber(bookDTO.getPageNumber());

       bookRepository.save(book);

    }
}
