package com.janavar.service;

import com.janavar.domain.Member;
import com.janavar.dto.MemberDTO;
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

    public void createMember(MemberDTO memberDTO) {

        Member member=new Member();
        member.setMemberName(memberDTO.getMemberName());
        member.setMemberSurname(memberDTO.getMemberSurname());
        member.setEmail(memberDTO.getEmail());
        member.setMemberPhone(memberDTO.getMemberPhone());


        memberRepository.save(member);

    }

    public void updateMember(Long id, MemberDTO memberDTO) {

        Member member = getMemberId(id);
        member.setMemberName(memberDTO.getMemberName());
        member.setMemberSurname(memberDTO.getMemberSurname());
        member.setEmail(memberDTO.getEmail());
        member.setMemberPhone(memberDTO.getMemberPhone());

        memberRepository.save(member);

    }

    public void deleteMember(Long id) {

        Member member = getMemberId(id);

        memberRepository.delete(member);





    }
}
