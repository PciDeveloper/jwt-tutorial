package com.example.jwt.jwttutorial.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity // Web 기본적인 보안을 활성화 시키는 어노테이션
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests() // HttpServletRequest 를 사용하는 요청들에 대한 접근 제한을 설정하겠다는 의미
                .antMatchers("/api/hello").permitAll() // 이러한 api 요청은 인증없이 접근을 허용하겠다는 의미
                .anyRequest().authenticated(); // 그 외에 나머지 요청들에 대해서는 모두 인증이 되어야한다는 의미
    }
}
