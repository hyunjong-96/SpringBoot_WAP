package org.sopt.seminar8.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
public class Member {
    public Member(){ }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;
}
