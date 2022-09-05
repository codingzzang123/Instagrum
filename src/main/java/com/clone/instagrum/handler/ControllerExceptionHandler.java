package com.clone.instagrum.handler;

import com.clone.instagrum.dto.common.ResponseDto;
import com.clone.instagrum.dto.error.ErrorResponse;
import com.clone.instagrum.dto.error.StatusEnum;
import com.clone.instagrum.handler.ex.CustomValidationException;
import com.clone.instagrum.handler.ex.UserDuplicatedException;
import com.clone.instagrum.util.Script;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.Charset;


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


//    @ExceptionHandler(CustomValidationException.class)
//    public String validationException(CustomValidationException e){
//
//        return Script.back(e.getErrorMap().toString());
//    }

//    @ExceptionHandler(UserDuplicatedException.class)
//    public String userDuplicatedException(UserDuplicatedException e){
//
//        return Script.back(e.getMessage());
//    }

//    @ExceptionHandler(UserDuplicatedException.class)
//    @ResponseBody
//    public String userDuplicatedException(UserDuplicatedException e){
//        HttpHeaders header = new HttpHeaders();
//        header.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
//
//        ErrorResponse errorResponse = new ErrorResponse(StatusEnum.INTERNAL_SERVER_ERROR,e.getMessage());
//        ResponseEntity<ErrorResponse> ds =  new ResponseEntity<>(errorResponse, header, HttpStatus.INTERNAL_SERVER_ERROR);
//
//
//        System.out.println("StatusEnum.INTERNAL_SERVER_ERROR = " + StatusEnum.INTERNAL_SERVER_ERROR);
//        System.out.println("Header = "+ds.getHeaders());
//        System.out.println("Body = "+ds.getBody());
//        return "gi";
//    }

//    @ExceptionHandler(UserDuplicatedException.class)
//    @ResponseBody
//    public ResponseEntity<ErrorResponse> userDuplicatedException(UserDuplicatedException e){
//
//        ErrorResponse errorResponse = new ErrorResponse();
//        errorResponse.setStatus(StatusEnum.INTERNAL_SERVER_ERROR);
//        errorResponse.setMessage(e.getMessage());
//
//        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
//    }

@ControllerAdvice //전역에러 캐치
public class ControllerExceptionHandler {

    @ExceptionHandler({UserDuplicatedException.class,CustomValidationException.class})
    public String userDuplicatedException(Exception e, Model model){
        model.addAttribute("message",e.getMessage());
        return "error/errorPage";
    }

}
