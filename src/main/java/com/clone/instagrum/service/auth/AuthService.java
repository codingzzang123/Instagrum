package com.clone.instagrum.service.auth;

import com.clone.instagrum.domain.repository.UserRepository;
import com.clone.instagrum.domain.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * packageName    : com.clone.instagrum.service.auth
 * fileName       : AuthService
 * author         : Hosun
 * date           : 2022-09-03
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-09-03        Hosun              최초 생성
 */
@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Transactional //Write(Insert, Update, Delete)
    public User signin(User user){

        user.setPassword(
                bCryptPasswordEncoder.encode(user.getPassword())
        );

        user.setRole("ROLE_USER");
        //관리자는 "ROLE_ADMIN"
//        Optional<User> isMember = userRepository.findUserByUsername(user.getUsername());
//
//        if(isMember.isPresent())
//            User userEntity = userRepository.save(user);
//        else
//

        User userEntity = userRepository.save(user);
        /* <S extends T>S save(S entity) */
        return userEntity;
    }
}
