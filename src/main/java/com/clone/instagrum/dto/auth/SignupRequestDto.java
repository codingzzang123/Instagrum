package com.clone.instagrum.dto.auth;

import com.clone.instagrum.domain.user.User;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
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


    @NotBlank
    @Pattern(regexp ="^(?=.*[A-Za-z])[0-9a-zA-Z]{4,12}$")
    private String username; //id

    @NotBlank
    @Pattern(regexp ="^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{7,13}$")
    private String password;

    @NotBlank
    @Pattern(regexp ="^[0-9a-zA-Z]([-_\\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\\.]?[0-9a-zA-Z])*\\.[a-zA-Z]{2,3}$")
    private String email;

    @NotBlank
    @Pattern(regexp = "^[가-힣]{2,4}")
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
