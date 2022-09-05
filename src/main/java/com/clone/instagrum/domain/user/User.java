package com.clone.instagrum.domain.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * packageName    : com.clone.instagrum.domain.user
 * fileName       : User
 * author         : Hosun
 * date           : 2022-09-02
 * description    : User 도메인
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-09-02        Hosun              최초 생성
 */

//JPA = Java Persistence API(자바로 데이터를 영구적으로 저장할 수 있는 API를 제공)
@Entity //DB에 테이블을 생성해줌
@Data @NoArgsConstructor @AllArgsConstructor
@Builder
public class User {
    @Id //id가 PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) //번호 증가 전략이 DB(Oracle, mysql, maria db..)를 따라간다.
    private int id;

    @Column(length = 50, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String name;

    private String website;

    private String bio; //자기 소개

    @Column(nullable = false)
    private String email;

    private String phone;

    private String gender;

    private String profileImageUrl; //유저사진
    private String role; //권한

    private LocalDateTime createDate;

    @PrePersist //DB에 insert되기 직전에 실행되게끔
    public void createDate(){
        this.createDate = LocalDateTime.now();
    }
}
