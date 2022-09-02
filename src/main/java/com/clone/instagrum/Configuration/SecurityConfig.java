package com.clone.instagrum.Configuration;

import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.autoconfigure.security.ConditionalOnDefaultWebSecurity;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

/**
 * packageName    : com.clone.instagrum.Configuration
 * fileName       : SecurityConfig
 * author         : Hosun
 * date           : 2022-09-02
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-09-02        Hosun              최초 생성
 */
@EnableWebSecurity // 해당 파일로 시큐리티를 활성화
@Configuration(proxyBeanMethods = false)
@ConditionalOnDefaultWebSecurity
@ConditionalOnWebApplication(type = ConditionalOnWebApplication.Type.SERVLET)
public class SecurityConfig {

    @Bean
    @Order(SecurityProperties.BASIC_AUTH_ORDER)
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                    .antMatchers("/","/user/**","/image/**","/subscribe/**","/comment/**").authenticated()//인증이 필요한 페이지는 아무나 못들어감
                    .anyRequest().permitAll()
                .and()
                    .formLogin()
                    .loginPage("/auth/signin")//이쪽 경로로 자동 매핑
                    .defaultSuccessUrl("/"); //로그인이 정상적으로 처리되면 "/"로 리다이렉트
        return http.build();
    }

}
