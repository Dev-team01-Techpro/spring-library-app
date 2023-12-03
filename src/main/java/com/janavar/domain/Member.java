package com.janavar.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_members")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Setter(AccessLevel.NONE)
    private Long memberId;

    @NotBlank(message = "Kullanici adi bos birakilamaz!")
    @Size(min = 2, max = 35, message = "'${validatedValue}' uzunlugu {min} ve {max} arasinda olmalidir!")
    @Column(name = "member_name", nullable = false, length = 35)
    private String memberName;

    @NotBlank(message = "Kullanici soyadi bos birakilamaz!")
    @Size(min = 2, max = 35, message = "'${validatedValue}' uzunlugu {min} ve {max} arasinda olmalidir!")
    @Column(name = "member_surname", nullable = false, length = 35)
    private String memberSurname;

    @Column(name = "member_phone", length = 15, unique = true)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "+###########")
    private String memberPhone;

    @Email
    @Column(name = "member_email", unique = true)
    private String email;

    @OneToMany(mappedBy = "member", fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Book> book;

}
