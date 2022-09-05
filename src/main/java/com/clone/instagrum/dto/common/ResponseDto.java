package com.clone.instagrum.dto.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

/**
 * packageName    : com.clone.instagrum.dto.common
 * fileName       : ResponseDto
 * author         : Hosun
 * date           : 2022-09-03
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-09-03        Hosun              최초 생성
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDto<T> {

    private int code; //1(성공) -1(실패)
    private String message;
    private T data;

}
