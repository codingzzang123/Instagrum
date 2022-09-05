package com.clone.instagrum.configuration.auth;

import com.clone.instagrum.domain.repository.UserRepository;
import com.clone.instagrum.domain.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * packageName    : com.clone.instagrum.configuration.auth
 * fileName       : PrincipalDetailsService
 * author         : Hosun
 * date           : 2022-09-03
 * description    : Security 로그인 설정 파일 (1)
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-09-03        Hosun              최초 생성
 */
@Service
@RequiredArgsConstructor
public class PrincipalDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {

        Optional<User> userEntity = userRepository.findByUsername(id);

        return userEntity == null ? null : new PrincipalDetails(userEntity.get());
    }
}
