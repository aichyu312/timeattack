package com.sparta.timeattack.domain;


import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Getter
@Entity
@NoArgsConstructor
public class Member extends Timestamped {

    @Id //id를 PK (primary Key 로 사용하겠다고 함)
    @GeneratedValue(strategy = GenerationType.AUTO) //값이 자동으로 증가하며 저장
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private int age;

    @Column(nullable = false)
    public int gender;


    public Member(String name,String email,int age, int gender) {
        this.name = name;
        this.email = email;
        this.age = age;
        this.gender = gender;
    }

    public void updateMember(MemberRequestDto requestDto) {
        this.name = requestDto.getName();
        this.email = requestDto.getEmail();
        this.age = requestDto.getAge();
        this.gender = requestDto.getGender();
    }

}
