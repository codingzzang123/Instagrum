package com.clone.instagrum.service.user;

import com.clone.instagrum.domain.repository.UserRepository;
import com.clone.instagrum.domain.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * packageName    : com.clone.instagrum.service.user
 * fileName       : UserService
 * author         : Hosun
 * date           : 2022-09-03
 * description    : UserService 구현
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-09-03        Hosun              최초 생성
 */
@Service
@RequiredArgsConstructor
public class UserService {
    /*
    * 1. 영속화
    * 2. 영속화된 오브젝트를 수정 - 더티체킹(업데이트 완료)*/

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Transactional
    public User updateUser(int id, User user){
        User userEntity = userRepository.findById(id).get();
        //1. 무조건 찾았다 get() 2.못찾았어 -> 익셉션 발동할게  orElseThrow()
        userEntity.setName(user.getName());

        String rawPassword = user.getPassword();
        String encPassword = bCryptPasswordEncoder.encode(rawPassword);

        userEntity.setPassword(encPassword);
        userEntity.setBio(user.getBio());
        userEntity.setWebsite(user.getWebsite());
        userEntity.setPhone(user.getPhone());
        userEntity.setGender(user.getGender());

        return userEntity; //이때 더티체킹이 일어나 업데이트 완료.
    }
}
