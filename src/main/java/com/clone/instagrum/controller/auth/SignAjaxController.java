package com.clone.instagrum.controller.auth;

import com.clone.instagrum.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * packageName    : com.clone.instagrum.controller.auth
 * fileName       : AuthAjaxController
 * author         : Hosun
 * date           : 2022-09-04
 * description    : 회원가입 jsp에서 유효성 검사 목적 컨트롤러
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-09-04        Hosun              최초 생성
 */
@RestController
@RequiredArgsConstructor
public class SignAjaxController {

    private final UserRepository userRepository;

    @PostMapping("/auth/check")
    public int checkId(String id){
        if(userRepository.findByUsername(id).isPresent()){
            return 1;
        }
        return -1;
    }
}
