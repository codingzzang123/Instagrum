package com.clone.instagrum.dto.user;

import com.clone.instagrum.domain.user.User;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

/**
 * packageName    : com.clone.instagrum.dto.user
 * fileName       : UserUpdateDto
 * author         : Hosun
 * date           : 2022-09-03
 * description    : 회원 정보 수정요청 DTO
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-09-03        Hosun              최초 생성
 */
@Data
public class UserUpdateDto {
    @NotBlank
    @Pattern(regexp = "^[가-힣]{2,4}")
    private String name; //필수

    @NotBlank
    @Pattern(regexp ="^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{7,13}$")
    private String password; //필수
    private String website;
    private String bio;
    private String phone;
    private String gender;

    // 코드 수정이 필요할 예정.(필수아닌것들도 있어서 조금 위험함)
    public User toEntity(){
        return User.builder()
                .name(name)
                .password(password)
                .website(website)
                .bio(bio)
                .phone(phone)
                .gender(gender)
                .build();
    }
}
