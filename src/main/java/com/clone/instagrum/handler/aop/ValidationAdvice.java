package com.clone.instagrum.handler.aop;

import com.clone.instagrum.handler.ex.CustomValidationException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.HashMap;
import java.util.Map;

/**
 * packageName    : com.clone.instagrum.handler.aop
 * fileName       : ValidationAdvice
 * author         : Hosun
 * date           : 2022-09-05
 * description    : aop 유효성 검사 공통 기능
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-09-05        Hosun              최초 생성
 */
@Component //RestController,Service 이런 모든 것들이 Component를 상속해서 만들어짐
@Aspect //aop처리 할 수 있는 핸들러의미
public class ValidationAdvice {

    @Around("execution(* com.clone.instagrum.controller..*Controller.*(..))")
    public Object Advice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        Object[] args = proceedingJoinPoint.getArgs();
        for(Object arg : args){
            if(arg instanceof BindingResult){
                BindingResult bindingResult = (BindingResult) arg;

                if(bindingResult.hasErrors()){
                    Map<String,String> errorMap = new HashMap<>();

                    for(FieldError error : bindingResult.getFieldErrors()){
                        errorMap.put(error.getField(), error.getDefaultMessage());
                    }
                    throw new CustomValidationException("유효성 검사 실패",errorMap);
                }
            }
        }
         return proceedingJoinPoint.proceed();
    }
    /*
        ProceedingJoinPoint
        어떤 메소드가 실행될때 매게변수나 그 메소드의 내용을 전부 알 수 있음.
        그 함수의 모든 내용을 ProceedingJoinPoint여기에 담음.
        ProceedingJoinPoint
        리턴값은 그 함수로 다시 돌아가라 라는 의미임. 리턴할 때 해당 함수가 실행되는 구조
    * */
}
