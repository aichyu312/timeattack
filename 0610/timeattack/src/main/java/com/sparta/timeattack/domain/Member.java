package com.sparta.timeattack.domain;


import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Getter
@Entity
@NoArgsConstructor
public class Member extends Timestamped {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private int age;

    @Column(nullable = false)
    private int gender;


    public Member(MemberRequestDto requestDto) {
        this.name = requestDto.getName();
        this.email = requestDto.getEmail();
        this.age = requestDto.getAge();
        this.gender = requestDto.getGender();


    }
    public Member(String name,String email,int age, int gender) {
        this.name = name;
        this.email = email;
        this.age = age;
        this.gender = gender;
    }

    public void update(MemberRequestDto requestDto) {
        this.name = requestDto.getName();
        this.email = requestDto.getEmail();
        this.age = requestDto.getAge();
        this.gender = requestDto.getGender();
    }





}
