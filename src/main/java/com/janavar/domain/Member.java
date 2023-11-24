package com.janavar.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "tb_members")
@Getter
@Setter
@RequiredArgsConstructor
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Kullanıcı adı boş bırakılamaz")
    @Column(name = "member_name",nullable = false,length = 35)
    @Size(min = 2, max = 35, message = "'${valitedValue}' uzunluğu {min} ve {max} arasında olmalı")
    private final String memberName;

    @NotBlank(message = "Kullanıcı soyadı boş bırakılamaz")
    @Column(name = "member_surname",nullable = false,length = 35)
    @Size(min = 2, max = 35,message = "'${valitedValue}' uzunluğu {min} ve {max} arasında olmalı")
    private final String memberSurname;

    @Column(name = "member_phonenumber",length = 35,unique = true)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "+###########")
    private final String phoneNumber;

    @Email
    private final String email;

    @OneToMany(mappedBy = "member",fetch = FetchType.EAGER)
    private List<Book> book;





}
