package org.sopt.seminar8.domain;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Entity
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column(name = "team_name")
    private String name;

    //양방향 매핑(with Member)
    @OneToMany(mappedBy = "team")
    private List<Member> members = new ArrayList<>();
}
