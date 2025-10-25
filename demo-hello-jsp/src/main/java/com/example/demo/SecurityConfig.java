package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth
                .anyRequest().permitAll() // �S�Ẵ��N�G�X�g������
            )
            .formLogin(form -> form
                    .loginPage("/login/login")   // ���샍�O�C�����
                    .permitAll()
                )
//            .csrf(csrf -> csrf.disable()); // �J���p��CSRF�������i�K�v�Ȃ�j
            ;
        return http.build();
    }
}
