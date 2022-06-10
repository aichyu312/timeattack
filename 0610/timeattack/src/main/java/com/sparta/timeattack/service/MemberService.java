package com.sparta.timeattack.service;


import com.sparta.timeattack.domain.Member;
import com.sparta.timeattack.domain.MemberRepository;
import com.sparta.timeattack.domain.MemberRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class MemberService {
    private final MemberRepository memberRepository;

    @Transactional
    public Long update(Long id, MemberRequestDto requestDto) {
        Member member1 = memberRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 아이디가 존재하지 않습니다.")
        );
        member1.update(requestDto);
        return member1.getId();
    }
}
