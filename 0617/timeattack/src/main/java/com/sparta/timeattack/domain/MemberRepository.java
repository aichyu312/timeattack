package com.sparta.timeattack.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sparta.timeattack.domain.Member;
import java.util.List;


public interface MemberRepository extends JpaRepository<Member, Long> {
    List<Member> findAllByAgeEqualsAndGenderNot(int age, int gender);
}
