package com.sparta.timeattack.controller;

import com.sparta.timeattack.domain.Member;
import com.sparta.timeattack.domain.MemberRepository;
import com.sparta.timeattack.domain.MemberRequestDto;
import com.sparta.timeattack.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


//final인 필드값을 파라미터로 받는 생성자 생성
@RequiredArgsConstructor
//각종 mapping 을 위해 선언
@RestController


public class MemberController {

    private final MemberRepository memberRepository;
    private final MemberService memberService;

    @PostMapping("/create")
    public Member postMember(@RequestBody Member requestDto) {
        return memberService.createMember(requestDto);
    }

    @PutMapping("/update/{id}")
    public Long updateMember(@PathVariable Long id, @RequestBody MemberRequestDto requestDto) {
        return memberService.updateMember(id, requestDto);
    }

    @DeleteMapping("/delete/{id}")
    public Long deleteMember(@PathVariable Long id) {
        memberService.deleteMember(id);
        return id;
    }

    @GetMapping("/read")
    public List<Member> getMembers(){
        return memberService.getMember();
    }


    @GetMapping("recommend/{id}")
    public List<Member> recommendMember(@PathVariable Long id) {
        return memberService.recommendMember(id);

    }
}
