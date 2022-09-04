package com.clone.instagrum.configuration.auth;

import com.clone.instagrum.domain.user.User;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

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
public class PrincipalDetails implements UserDetails {

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
//        collector.add(new GrantedAuthority() {
//            @Override
//            public String getAuthority() {
//                return user.getRole();
//            }
//        });

        collector.add(() -> {
           return user.getRole();
        });

        /*
            람다식으로 바꿨음.
            어차피 add안에 함수를 넣고 싶은게 목적임
            근데 자바에서는 매게변수에 함수를 못넣음(1급 객체가 아니라)
            인터페이스나 Object를 넣을 수 있음.
            따라서 람다식으로 함수를 넘겨 줬음.
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
}
