package com.janavar.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.janavar.domain.Member;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MemberDTO {

    private Long memberId;

    @NotBlank(message = "Kullanici adi bos birakilamaz!")
    @Size(min = 2, max = 35, message = "'${validatedValue}' uzunlugu {min} ve {max} arasinda olmalidir!")
    private String memberName;

    @NotBlank(message = "Kullanici soyadi bos birakilamaz!")
    @Size(min = 2, max = 35, message = "'${validatedValue}' uzunlugu {min} ve {max} arasinda olmalidir!")
    private String memberSurname;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "+###########")
    private String memberPhone;

    @Email
    private String email;

    public MemberDTO(Member member) {
        this.memberId =member.getMemberId();
        this.memberName = member.getMemberName();
        this.memberSurname = member.getMemberSurname() ;
        this.memberPhone = member.getMemberPhone();
        this.email = member.getEmail();

    }
}
