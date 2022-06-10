package com.sparta.timeattack.domain;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@RequiredArgsConstructor

public class MemberRequestDto {
    private final String name;
    private final String email;
    private final int age;
    private final int gender;

}
