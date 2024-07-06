package com.conference.management.security;

import com.conference.management.service.IUserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

@Configuration
public class SecurityConfig {

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Bean
    public DaoAuthenticationProvider authenticationProvider(IUserService userService) {
        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
        auth.setUserDetailsService(userService);
        auth.setPasswordEncoder(passwordEncoder());
        return auth;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests(configurer ->
                        configurer
                                //.requestMatchers("/home/**").permitAll()
                                .requestMatchers("/home").hasAnyRole("USER")
                                .requestMatchers("/home/paper/all").hasAnyRole("USER")
                                .requestMatchers("/home/paper/save").hasAnyRole("AUTHOR")
                                .requestMatchers("/home/paper/assignment/details/{id}").hasAnyRole("AUTHOR")
                                .requestMatchers("/home/paper/evaluate/{id}").hasAnyRole("REVIEWER")
                                .requestMatchers("/home/paper/evaluate/process").hasAnyRole("REVIEWER")
                                .requestMatchers("/home/paper/reEvaluateRequest/{id}").hasAnyRole("AUTHOR")
                                .requestMatchers("/home/paper/revisionRequest").hasAnyRole("REVIEWER")
                                .requestMatchers("/home/paper/revision/process").hasAnyRole("AUTHOR")
                                .requestMatchers("/home/paper/save/process").hasAnyRole("AUTHOR")
                                .requestMatchers("/home/paper/myPaper").hasAnyRole("AUTHOR")
                                .requestMatchers("/home/paper/myAssignments").hasAnyRole("REVIEWER")
                                .requestMatchers("/home/reviewer/setAssignmentEnable").hasAnyRole("REVIEWER")
                                .requestMatchers("/**").permitAll()
                                .anyRequest().authenticated()
                )
                .csrf(csrf -> csrf.disable())
                .formLogin(form ->
                        form
                                .loginPage("/login")
                                .loginProcessingUrl("/authenticateTheUser")
                                .successHandler(new SimpleUrlAuthenticationSuccessHandler("/home"))
                                .permitAll()
                )
                .logout(logout -> logout.permitAll()
                );

        return http.build();
    }
}

