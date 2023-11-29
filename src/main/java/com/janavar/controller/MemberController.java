package com.janavar.controller;

import com.janavar.domain.Member;
import com.janavar.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/member")
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





}
