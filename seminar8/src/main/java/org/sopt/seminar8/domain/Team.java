package org.sopt.seminar8.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Entity
public class Team {
    public Team(){ }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    //양방향 매핑(with Member)
    @OneToMany(mappedBy = "team")
    private List<Member> members = new ArrayList<>();
}
