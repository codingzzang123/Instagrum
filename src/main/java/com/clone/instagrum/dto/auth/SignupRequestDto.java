package com.clone.instagrum.dto.auth;

import com.clone.instagrum.domain.user.User;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * packageName    : com.clone.instagrum.dto.auth
 * fileName       : SignupRequestDto
 * author         : Hosun
 * date           : 2022-09-02
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-09-02        Hosun              최초 생성
 */
@Data //Getter , Setter
public class SignupRequestDto {

    @Size(min = 4, max = 20)
    @NotBlank
    private String username; //id

    @NotBlank
    private String password;

    @NotBlank
    private String email;

    @NotBlank
    private String name;

    public User toEntity(){
        return User.builder()
                .username(username)
                .password(password)
                .email(email)
                .name(name)
                .build();
    }
}
