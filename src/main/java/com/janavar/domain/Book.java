package com.janavar.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Book {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Setter(AccessLevel.NONE)
private Long bookId;

@NotBlank(message = "Kitap adi bos birakilamaz")
@Size(min = 1, max=55, message = "'${validatedValue}' isimli kitap {min} ve {max} arasinda olmalidir")
@Column(nullable = false, length = 55)
private  String bookName;


@NotBlank(message = "Kitap basım yılı bos birakilamaz")
@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy")
@Column(nullable = false, length = 4)
private  String publishYear;

@NotBlank(message = "Kitap yazari bos birakilamaz")
@Size(min = 1, max=30, message = "'${validatedValue}' isimli yazar adi; {min} ve {max} arasinda olmalidir")
@Column(nullable = false, length = 30)
private String author;

@NotBlank(message = "Kitap sayfa sayisi bos birakilamaz")
@Size(min = 1, max=4, message = "'${validatedValue}' isimli kitap sayfa sayisi; {min} ve {max} arasinda olmalidir")
@Column(nullable = false, length = 4)
private String pageNumber;

// Todo enum typelar tanimlanip degiskenler oradan cekilecek
@NotBlank(message = "Kitap sayfa sayisi bos birakilamaz")
@Size(min = 1, max=30, message = "'${validatedValue}' isimli kitap turu; {min} ve {max} arasinda olmalidir")
@Column(nullable = false, length = 30)
private String type;

@ManyToOne
@JoinColumn(name ="member_id")
private Member member;








}




