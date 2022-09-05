package com.clone.instagrum.configuration.auth;

import com.clone.instagrum.domain.repository.UserRepository;
import com.clone.instagrum.domain.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;
import java.util.UUID;

/**
 * packageName    : com.clone.instagrum.configuration.auth
 * fileName       : OAuth2DetailsService
 * author         : Hosun
 * date           : 2022-09-05
 * description    : oauth 서비스 - 회원정보 받기
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-09-05        Hosun              최초 생성
 */
@Service
@RequiredArgsConstructor
public class OAuth2DetailsService extends DefaultOAuth2UserService {

    private final UserRepository userRepository;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {

        OAuth2User oAuth2User = super.loadUser(userRequest);

        Map<String,Object> userInfo = oAuth2User.getAttributes(); //email, public-profile 정보를 받음
        String name = (String)userInfo.get("name");
        String email = (String)userInfo.get("email");

        /* 유저 ID는 강제로, 하지만 중복 되지않게 */
        String username = "facebook_"+(String)userInfo.get("id");

        /* 유니크한 패스워드 */
        String password = new BCryptPasswordEncoder().encode(UUID.randomUUID().toString());

        /* 무조건 save()가 아니라 한번 페이스북 로그인 진행 했다면 insert 하면 안됨. */
        Optional<User> userEntity = userRepository.findByUsername(username);
        if(userEntity.isPresent()){
            return new PrincipalDetails(userEntity.get());

        }else{
            User user = User.builder()
                    .username(username)
                    .password(password)
                    .name(name)
                    .email(email)
                    .role("ROLE_USER")
                    .build();

            return new PrincipalDetails(userRepository.save(user));
        }
    }
}
