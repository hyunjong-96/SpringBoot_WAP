package org.sopt.seminar8.repository;

import org.sopt.seminar8.domain.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team,Long> {
}
