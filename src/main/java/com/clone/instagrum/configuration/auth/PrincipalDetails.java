package com.clone.instagrum.configuration.auth;

import com.clone.instagrum.domain.user.User;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/**
 * packageName    : com.clone.instagrum.configuration.auth
 * fileName       : PrincipalDetails
 * author         : Hosun
 * date           : 2022-09-03
 * description    : UserDetails 리턴
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-09-03        Hosun              최초 생성
 */
@Data
public class PrincipalDetails implements UserDetails, OAuth2User {

    private static final long serialVersionUID =1L;

    private User user;

    public PrincipalDetails(User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        /* 권한을 가져오는 메소드
            권한: 한개가 아닐 수 있음. -> Collection

        * */

        Collection<GrantedAuthority> collector = new ArrayList<>();
        collector.add(() -> {
           return user.getRole();
        });
        /*
            add안에 함수를 넣고 싶은게 목적이므로 람다식으로 간단하게.
            근데 자바에서는 매게변수에 함수를 못넣음(1급 객체가 아니라)
            인터페이스나 Object를 넣을 수 있음. 따라서 람다식으로 함수를 넘겨 줬음.
        * */
        return collector;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

//    @Override
//    public String getName() {
//        String name = (String)attributes.get("name");
//        return name;
//    }
//
//    @Override
//    public Map<String, Object> getAttributes() {
//        return attributes;
//    }
    @Override
    public Map<String, Object> getAttributes() {
        return null;
    }

    @Override
    public String getName() {
        return null;
    }
}
//    private User user;
//    private Map<String, Object> attributes;
//
//    public PrincipalDetails(User user) {
//        this.user = user;
//    }
//
//    public PrincipalDetails(User user, Map<String, Object> attributes) {
//        this.user = user;
//        this.attributes = attributes;
//    }