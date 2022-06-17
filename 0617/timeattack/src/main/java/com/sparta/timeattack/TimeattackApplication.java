package com.sparta.timeattack;

import com.sparta.timeattack.domain.Member;
import com.sparta.timeattack.domain.MemberRepository;
import com.sparta.timeattack.domain.MemberRequestDto;
import com.sparta.timeattack.service.MemberService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.List;

@EnableJpaAuditing //Spring Auditing 을 위한 어노테이션 추가 (Timestamped에서 Auditing 사용)
@SpringBootApplication
public class TimeattackApplication {

    public static void main(String[] args) {
        SpringApplication.run(TimeattackApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(MemberRepository memberRepository){
        return (args) -> {
            memberRepository.save(new Member("강현규","aichyu@naver.com",30,0));


        };
    }

}

