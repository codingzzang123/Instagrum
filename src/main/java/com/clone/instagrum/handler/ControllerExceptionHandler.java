package com.clone.instagrum.handler;

import com.clone.instagrum.dto.common.ResponseDto;
import com.clone.instagrum.handler.ex.CustomValidationException;
import com.clone.instagrum.handler.ex.UserDuplicatedException;
import com.clone.instagrum.util.Script;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * packageName    : com.clone.instagrum.handler
 * fileName       : ControllerExceptionHandler
 * author         : Hosun
 * date           : 2022-09-03
 * description    : 전역 에러 처리
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-09-03        Hosun              최초 생성
 */
@RestController
@ControllerAdvice //익셈션 가로챔
public class ControllerExceptionHandler {

    @ExceptionHandler(CustomValidationException.class)
    public String/*ResponseDto<?>*/ validationException(CustomValidationException e){

        return Script.back(e.getErrorMap().toString());
//        return new ResponseDto(-1,e.getMessage(),e.getErrorMap());
    }

    @ExceptionHandler(UserDuplicatedException.class)
    public String userDuplicatedException(UserDuplicatedException e){
        return Script.back(e.getMessage());
    }
}
