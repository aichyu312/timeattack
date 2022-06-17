package com.sparta.timeattack.service;


import com.sparta.timeattack.domain.Member;
import com.sparta.timeattack.domain.MemberRepository;
import com.sparta.timeattack.domain.MemberRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class MemberService {
    private final MemberRepository memberRepository;

    @Transactional
    public Long updateMember(@PathVariable Long id, MemberRequestDto requestDto) {
        Member member1 = memberRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 아이디가 존재하지 않습니다.")
        );
        member1.updateMember(requestDto);
        return member1.getId();
    }

    public Member createMember(Member member){
        return memberRepository.save(member);
    }

    public List<Member> getMember(){
        return memberRepository.findAll();
    }

    public void
    deleteMember(@PathVariable Long id) {
        memberRepository.deleteById(id);
    }

    public List<Member> recommendMember(@PathVariable Long id){
        Optional<Member> member = memberRepository.findById(id);
        int gender = member.get().getGender();
        int age = member.get().getAge();
        return memberRepository.findAllByAgeEqualsAndGenderNot(age, gender);

    }
}
