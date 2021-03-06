package com.sparta.timeattack.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sparta.timeattack.domain.Member;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;
import java.util.Optional;


public interface MemberRepository extends JpaRepository<Member, Long> {
    List<Member> findAllByAgeEqualsAndGenderNot(int age, int gender);


    Optional<Member> findByEmail(String email);
}
