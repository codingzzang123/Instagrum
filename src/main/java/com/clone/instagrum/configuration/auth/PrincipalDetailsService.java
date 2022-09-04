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
public class PrincipalDetailsService implements UserDetailsService { //UserDetailsService얘가 낚아 챔

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
        /* 구현 해야 할 부분
            1. username 이 있는지 없는지 체크 (패스워드는 알아서 체킹해주기 떄문에 신경x)
            2. UserDetials 타입으로 리턴 -> 리턴되면 자동으로 세션을 만듦.
            2-1
        * */
        Optional<User> userEntity = userRepository.findByUsername(id);

        return userEntity == null ? null : new PrincipalDetails(userEntity.get());
    }
}
