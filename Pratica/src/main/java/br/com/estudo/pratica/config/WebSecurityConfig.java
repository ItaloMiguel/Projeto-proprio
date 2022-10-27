package br.com.estudo.pratica.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class WebSecurityConfig {

    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .httpBasic()
                .and()
                .authorizeHttpRequests()
                .antMatchers(HttpMethod.GET, "/home/**").permitAll()
                .antMatchers(HttpMethod.POST, "/home/**").hasRole("USER")
                .antMatchers(HttpMethod.DELETE, "/home/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/hello/**").permitAll()
                .antMatchers(HttpMethod.POST, "/hello/**").hasRole("USER")
                .antMatchers(HttpMethod.POST, "/hello/**").hasRole("ADMIN")
                .anyRequest().authenticated()
                .and()
                .csrf().disable().build();
    }

}
