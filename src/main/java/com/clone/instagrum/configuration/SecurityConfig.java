package com.clone.instagrum.configuration;

import com.clone.instagrum.configuration.auth.OAuth2DetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.autoconfigure.security.ConditionalOnDefaultWebSecurity;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
@RequiredArgsConstructor
public class SecurityConfig {

    private final OAuth2DetailsService oAuth2DetailsService;

    @Bean
    @Order(SecurityProperties.BASIC_AUTH_ORDER)
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/","/user/**","/main/**").authenticated()
                .anyRequest().permitAll()
            .and()
                .formLogin()
                .loginPage("/auth/signin")
                .loginProcessingUrl("/auth/signin")
                .usernameParameter("id") //default = username
                .defaultSuccessUrl("/")
            .and()
                .oauth2Login()
                .userInfoEndpoint()
                .userService(oAuth2DetailsService);
        return http.build();
    }

    @Bean
    public BCryptPasswordEncoder encoder(){
        return new BCryptPasswordEncoder();
    }

}

/*
     @Bean
    @Order(SecurityProperties.BASIC_AUTH_ORDER)
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/","/user/**","/main/**","/subscribe/**","/comment/**").authenticated()//인증이 필요한 페이지는 아무나 못들어감
                .anyRequest().permitAll()
            .and()
                .formLogin()
                .loginPage("/auth/signin")//이쪽 경로로 자동 매핑(get) 인증이 안되어있으면
                .loginProcessingUrl("/auth/signin") // post -> 시큐리티가 로그인 프로세스 진행
                .usernameParameter("id") //default = "username"
                .passwordParameter("password")
                .defaultSuccessUrl("/") //로그인이 정상적으로 처리되면 "/"로 리다이렉트
            .and()
                .oauth2Login() // 일반 로그인도 하겠지만 oauth2 로그인도 함
                .userInfoEndpoint() // oauth 로그인 최종 응답을 인증 code 가 아니라, 회원 정보를 바로 받음.
                .userService(oAuth2DetailsService);
        return http.build();
    }
* */