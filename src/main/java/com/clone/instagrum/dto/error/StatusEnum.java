package com.clone.instagrum.dto.error;/**
 *packageName    : com.clone.instagrum.dto.error
 * fileName       : StatusEnum
 * author         : Hosun
 * date           : 2022-09-04
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-09-04        Hosun              최초 생성
 */
public enum StatusEnum {
    OK(200, "OK"),
    BAD_REQUEST(400, "BAD REQUEST"),
    NOT_FOUND(404, "NOT FOUND"),
    INTERNAL_SERVER_ERROR(500, "INTERNAL SERVER ERROR");

    int code;
    String message;

    StatusEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
