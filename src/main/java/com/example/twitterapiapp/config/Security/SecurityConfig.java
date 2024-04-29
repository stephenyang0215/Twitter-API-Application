//
//package com.example.twitterapiapp.config.Security;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.context.SecurityContextPersistenceFilter;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig  {
//
//
//    @Bean
//    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        return http
//                .addFilter(new SecurityContextPersistenceFilter())
//                .authorizeRequests( auth ->{
//                    auth.requestMatchers("/login", "/accessTokenByCode").permitAll();
//                    auth.anyRequest().authenticated();
//                 })
//                .formLogin(formLogin -> formLogin
//                        .loginPage("/login")
//                        .permitAll()
//                )
//                .logout(logout -> logout
//                        .permitAll()
//                )
//
//                .build();
//    }
//
//
//}
//
//
//
//
//
//
