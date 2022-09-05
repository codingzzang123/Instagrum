package com.clone.instagrum.handler.ex;

/**
 * packageName    : com.clone.instagrum.handler.ex
 * fileName       : UserDuplicatedException
 * author         : Hosun
 * date           : 2022-09-04
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-09-04        Hosun              최초 생성
 */
public class UserDuplicatedException extends RuntimeException{

//    private static final long serialVersionUID = 1L;
//
//    private String message;
//
//    public UserDuplicatedException(String message){
//        this.message = message;
//    }
//
//    @Override
//    public String getMessage(){
//        return this.message;
//    }

    private static final long serialVersionUID = 1L;

    private String message;

    public UserDuplicatedException(String message){
        this.message = message;
    }

    @Override
    public String getMessage(){
        return this.message;
    }

}
