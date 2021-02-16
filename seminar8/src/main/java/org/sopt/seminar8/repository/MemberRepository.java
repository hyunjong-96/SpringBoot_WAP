package org.sopt.seminar8.repository;

import org.sopt.seminar8.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member,Long> {
}
