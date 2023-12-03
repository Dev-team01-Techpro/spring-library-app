package com.janavar.controller;

import com.janavar.domain.Member;
import com.janavar.dto.MemberDTO;
import com.janavar.service.MemberService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/member") //http://localhost:8080/member
public class MemberController {

    @Autowired
    private MemberService memberService;

    //public ResponseEntity<List> listAllMembers()

    @GetMapping
    public ResponseEntity<List<Member>> listAllMember() {

        List<Member> memberList = memberService.getAllMember();

        return ResponseEntity.ok(memberList);

    }
    @GetMapping("/{id}")
    public ResponseEntity<Member>getMemberById (@PathVariable ("id")Long id){

        return ResponseEntity.ok (memberService.getMemberId(id));

    }

    @PostMapping
    public ResponseEntity<Map<String ,String>> createMember(@Valid @RequestBody MemberDTO memberDTO){

        memberService.createMember(memberDTO);

        Map<String,String> map=new HashMap<>();
        map.put("message:","Kaydimiz tamamlanmistir.");
        map.put("Status","true");

        return new ResponseEntity<>(map, HttpStatus.CREATED);
    }

    @PatchMapping ("/{id}") //http://localhost:8080/member/1 post+json
    // Todo PatchMapping ve PutMapping kullanima gore test edilecek. Kullanici sadece bir fieldi degistirmek istediginde
    public ResponseEntity<Map<String, String>> updateMember(@PathVariable ("id") Long id,@RequestBody @Valid MemberDTO memberDTO){

         memberService.updateMember(id, memberDTO);
         Map<String,String> message = new HashMap();
         message.put("messege","Update Islemi basarili");
         message.put("Status","True");
         return ResponseEntity.ok(message);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMember (@PathVariable("id")Long id) {

        memberService.deleteMember(id);
        String mesasge = " Member deleted succesfully";

        return ResponseEntity.ok(mesasge);


    }
}
