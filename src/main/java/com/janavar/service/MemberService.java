package com.janavar.service;

import com.janavar.domain.Member;
import com.janavar.exception.ResourceNotFoundException;
import com.janavar.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    public List<Member> getAllMember() {

       return memberRepository.findAll();
    }

    public Member getMemberId(Long id) {

        return memberRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Id not found"));
    }
}
