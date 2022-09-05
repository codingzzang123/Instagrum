package com.clone.instagrum.util;

/**
 * packageName    : com.clone.instagrum.util
 * fileName       : Script
 * author         : Hosun
 * date           : 2022-09-03
 * description    : 공통 응답 Script
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-09-03        Hosun              최초 생성
 */
public class Script {
    public static String back(String message){
        StringBuilder sb = new StringBuilder();
        sb.append("<script>");
        sb.append("alert('"+ message + "');");
        sb.append("history.back();");
        sb.append("</script>");

        return sb.toString();
    }
}

