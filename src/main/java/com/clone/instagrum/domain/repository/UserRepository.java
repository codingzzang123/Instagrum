package com.clone.instagrum.domain.repository;

import com.clone.instagrum.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * packageName    : com.clone.instagrum.domain.repository
 * fileName       : UserRepository
 * author         : Hosun
 * date           : 2022-09-03
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-09-03        Hosun              최초 생성
 */
//@Repository 어노테이션 없어도 IoC 등록이 자동으로 됨. JpaRepo를 상속받아서
public interface UserRepository extends JpaRepository<User,Integer> {
//    public Optional<User> findUserByUsername(String userName);
}
