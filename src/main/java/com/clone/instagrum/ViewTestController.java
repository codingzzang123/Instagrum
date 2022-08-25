package com.clone.instagrum;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * packageName    : com.clone.instagrum
 * fileName       : ViewTestController
 * author         : Hosun
 * date           : 2022-08-25
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-08-25        Hosun              최초 생성
 */
@Controller
public class ViewTestController {
    @GetMapping("/auth/signup")
    public String signupPage() {
        return "auth/signup";
    }
    @GetMapping("/auth/signin")
    public String signinPage() {
        return "auth/signin";
    }

    @GetMapping("/image/story")
    public String storyPage() {
        return "image/story";
    }

    @GetMapping("/image/popular")
    public String popularPage() {
        return "image/popular";
    }

    @GetMapping("/image/upload")
    public String uploadPage() {
        return "image/upload";
    }

    @GetMapping("/user/profile")
    public String profilePage() {
        return "user/profile";
    }

    @GetMapping("/user/update")
    public String updatePage() {
        return "user/update";
    }
}
