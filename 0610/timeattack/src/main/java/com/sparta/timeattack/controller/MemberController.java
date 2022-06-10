package com.sparta.timeattack.controller;

import com.sparta.timeattack.domain.Member;
import com.sparta.timeattack.domain.MemberRepository;
import com.sparta.timeattack.domain.MemberRequestDto;
import com.sparta.timeattack.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController

public class MemberController {
    private final MemberRepository memberRepository;

    private final MemberService memberService;

    @PostMapping("/api/post")
    public Member postMember(@RequestBody MemberRequestDto requestDto){
        Member member = new Member(requestDto);
        return memberRepository.save(member);
    }
}
