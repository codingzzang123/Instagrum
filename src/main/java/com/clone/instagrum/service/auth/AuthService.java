package com.clone.instagrum.service.auth;

import com.clone.instagrum.domain.repository.UserRepository;
import com.clone.instagrum.domain.user.User;
import com.clone.instagrum.handler.ex.CustomValidationException;
import com.clone.instagrum.handler.ex.UserDuplicatedException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;
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

    @Transactional
    public void signUp(User user){

        /* Back-end 검사 (중복된 아이디인지 아닌지) */
        userRepository.findByUsername(user.getUsername())
                .ifPresent(m -> {
                    throw new UserDuplicatedException("중복되는 아이디입니다.");
                });

        user.setPassword(
                bCryptPasswordEncoder.encode(user.getPassword())
        );
        user.setRole("ROLE_USER");//관리자는 "ROLE_ADMIN"

        userRepository.save(user);
    }
}

