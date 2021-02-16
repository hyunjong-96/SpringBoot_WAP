package org.sopt.seminar8.domain;

import lombok.*;

import javax.persistence.*;

//Spring Data JPA를 위한 Annotation
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
//JPA테이블 이름 명시, DB의 테이블 이름과 다를 경우 명사를 통해 매핑 가능
//테이블 네임 매핑, 기본값은 첫글자 대문자
public class Item {

    //기본기 Annotation
    @Id
    //기본키 자동생성, 기본키 생성을 DB에 맡긴다.
    //MySQL은 IDENTITY, ORACLE은 SEQUENCE, 자동은 AUTO
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //컬럼 이름 명시, DB의 컬럼 이름과 다를 경우 명사를 통해 매핑 가능.
    @Column(length = 500)
    private String name;

    @Builder
    public Item(String name){
        this.name = name;
    }
}
