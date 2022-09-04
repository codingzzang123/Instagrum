package com.clone.instagrum.controller.user;

import com.clone.instagrum.configuration.auth.PrincipalDetails;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.security.Security;

/**
 * packageName    : com.clone.instagrum.controller.user
 * fileName       : UserController
 * author         : Hosun
 * date           : 2022-09-03
 * description    : UserController 생성
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-09-03        Hosun              최초 생성
 */
@Controller
public class UserController {

    @GetMapping("/user/{id}")
    public String userProfile(@PathVariable int id){
        return "user/profile";
    }

    @GetMapping("/user/{id}/update")
    public String userUpdate(@PathVariable int id, @AuthenticationPrincipal PrincipalDetails principalDetails
        , Model model){
//        System.out.println("세션 정보 : "+ principalDetails.getUser());
//
//        Authentication auth =  SecurityContextHolder.getContext().getAuthentication();
//        System.out.println("세션 정보 : " + (PrincipalDetails)auth.getPrincipal());

//        model.addAttribute("principal", principalDetails.getUser());
        return "user/update";
    }
}
