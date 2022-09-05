package com.clone.instagrum.controller.main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * packageName    : com.clone.instagrum.controller.main
 * fileName       : MainController
 * author         : Hosun
 * date           : 2022-09-03
 * description    : 로그인 - view 연결하기 (메인 페이지)
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-09-03        Hosun              최초 생성
 */
@Controller
public class MainController {

    @GetMapping({"/", "main/story"})
    public String main(){
        return "main/story";
    }

    @GetMapping("main/popular")
    public String popular(){
        return "main/popular";
    }

    @GetMapping("main/upload")
    public String upload(){
        return "main/upload";
    }
}
