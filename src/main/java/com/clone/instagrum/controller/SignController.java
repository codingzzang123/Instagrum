package com.clone.instagrum.controller;

import com.clone.instagrum.dto.auth.SignupRequestDto;
import com.clone.instagrum.handler.ex.CustomValidationException;
import com.clone.instagrum.service.auth.AuthService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

/**
 * packageName    : com.clone.instagrum.controller.auth
 * fileName       : AuthController
 * author         : Hosun
 * date           : 2022-09-02
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-09-02        Hosun              최초 생성
 */
@Controller
@RequiredArgsConstructor //final 키워드가 있는 멤버에대한 생성자를 만들어준다.
public class SignController {

    private static final Logger log = LoggerFactory.getLogger(SignController.class);

    private final AuthService authService;

//    public AuthController(AuthService authService){
//        this.authService = authService;
//    }

    @GetMapping("/auth/signin")
    public String signinForm(){
        return "auth/signin";
    }

    @GetMapping("/auth/signup")
    public String signupForm(){
        return "auth/signup";
    }

    @PostMapping("/auth/signup")
    public String signUp(@Valid SignupRequestDto signupRequestDto, BindingResult bindingResult){

        authService.signUp(signupRequestDto.toEntity());
        return "redirect:signin";
    }
    /* key = value (x-www-form-urlencoded 방식) */
}
