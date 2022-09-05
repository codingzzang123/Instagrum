package com.clone.instagrum.dto.error;

import lombok.*;

/**
 * packageName    : com.clone.instagrum.dto.error
 * fileName       : ErrorResponse
 * author         : Hosun
 * date           : 2022-09-04
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-09-04        Hosun              최초 생성
 */
@Data
public class ErrorResponse {

    private StatusEnum status;
    private String message;

    /*  ResponseEntity 생성자 구조..!!
        public ResponseEntity(@Nullable T body, @Nullable MultiValueMap<String, String> headers, HttpStatus status {
            this(body, headers, (Object) status);
        }
    * */
    public ErrorResponse(){
        this.status = StatusEnum.BAD_REQUEST;
        this.message = null;
    }
}
