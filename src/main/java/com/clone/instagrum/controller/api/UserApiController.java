package com.clone.instagrum.controller.api;

import com.clone.instagrum.configuration.auth.PrincipalDetails;
import com.clone.instagrum.domain.user.User;
import com.clone.instagrum.dto.common.ResponseDto;
import com.clone.instagrum.dto.user.UserUpdateDto;
import com.clone.instagrum.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * packageName    : com.clone.instagrum.api
 * fileName       : UserApiController
 * author         : Hosun
 * date           : 2022-09-03
 * description    : User api Controller
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-09-03        Hosun              최초 생성
 */
@RestController
@RequiredArgsConstructor
public class UserApiController {

    private final UserService userService;

    @PutMapping("/api/user/{id}")
    public ResponseDto<?> updateUser(@PathVariable int id,
                                     @Valid UserUpdateDto userUpdateDto, BindingResult bindingResult,
                                     @AuthenticationPrincipal PrincipalDetails principalDetails){

        User userEntity = userService.updateUser(id,userUpdateDto.toEntity());
        principalDetails.setUser(userEntity);
        return new ResponseDto<>(1,"success userUpdate",userEntity);
    }
}
