package com.clone.instagrum.handler.ex;

import java.util.Map;

/**
 * packageName    : com.clone.instagrum.handler.ex
 * fileName       : CustomValidationException
 * author         : Hosun
 * date           : 2022-09-03
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-09-03        Hosun              최초 생성
 */
public class CustomValidationException extends RuntimeException{

    //객체를 구분할 때
    private static final long serialVersionUID = 1L;

    private Map<String,String> errorMap;

    public CustomValidationException(String message, Map<String,String> errorMap){
        super(message);
        this.errorMap = errorMap;
    }

    public Map<String,String> getErrorMap(){
        return errorMap;
    }
}
