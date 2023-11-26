package com.janavar.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long bookID;

    @NotBlank(message = "Kitap adi bos birakilamaz")
    @Size(min = 1, max = 55, message = "'${validatedValue}' isimli kitap {min} ve {max} arasinda olmalidir!")
    @Column(name = "book_name", nullable = false, length = 55)
    private String bookName;

    @NotBlank(message = "Kitap basim yili bos birakilamaz!")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy")
    private String publishYear;

    @NotBlank(message = "Kitap yazari bos birakilamaz!")
    @Size(min = 1, max = 30, message = "'${validatedValue}' isimli yazar; {min} ve {max} arasinda olmalidir!")
    @Column(name = "book_author", nullable = false, length = 30)
    private String author;

    @NotBlank(message = "Kitap sayfa sayisi bos birakilamaz!")
    @Size(min = 1, max = 4, message = "'${validatedValue}' isimli kitap sayfa sayisi; {min} ve {max} arasinda olmalidir!")
    @Column(name = "book_page", nullable = false, length = 4)
    private String pageNumber;

    @NotBlank(message = "Kitap turu bos birakilamaz!")
    @Size(min = 1, max = 30, message = "'${validatedValue}' isimli kitap turu; {min} ve {max} arasinda olmalidir!")
    @Column(name = "book_page", nullable = false, length = 30, unique = true)
    private String type;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;
}




