package com.janavar.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.janavar.domain.Book;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookDTO {

    private Long bookID;

    @NotBlank(message = "Kitap adi bos birakilamaz")
    @Size(min = 1, max = 55, message = "'${validatedValue}' isimli kitap {min} ve {max} arasinda olmalidir!")
    private String bookName;

    @NotBlank(message = "Kitap basim yili bos birakilamaz!")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy")
    private String publishYear;

    @NotBlank(message = "Kitap yazari bos birakilamaz!")
    @Size(min = 1, max = 30, message = "'${validatedValue}' isimli yazar; {min} ve {max} arasinda olmalidir!")
    private String author;

    @NotBlank(message = "Kitap sayfa sayisi bos birakilamaz!")
    @Size(min = 1, max = 4, message = "'${validatedValue}' isimli kitap sayfa sayisi; {min} ve {max} arasinda olmalidir!")
    private String pageNumber;

    @NotBlank(message = "Kitap turu bos birakilamaz!")
    @Size(min = 1, max = 30, message = "'${validatedValue}' isimli kitap turu; {min} ve {max} arasinda olmalidir!")
    private String type;


    public BookDTO(Book book) {
        this.bookID = book.getBookID();
        this.bookName = book.getBookName();
        this.publishYear = book.getPublishYear();
        this.author = book.getAuthor();
        this.pageNumber = book.getPageNumber();
        this.type = book.getType();
    }
}





