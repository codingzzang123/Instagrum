package com.clone.instagrum.controller.auth;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
public class AuthController {

    @GetMapping("/auth/signin")
    public String signinForm(){
        return "auth/signin";
    }

    @GetMapping("/auth/signup")
    public String signupForm(){
        return "auth/signup";
    }

    @PostMapping("/auth/signup")
    public String signUp(){
        return "redirect:signin";
    }
}
