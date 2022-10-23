/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qldv.configs;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.qldv.configs.handlers.LoginSuccessHandler;
import com.qldv.configs.handlers.LogoutHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 *
 * @author dieuh
 */
@Configuration
@EnableWebSecurity
@EnableTransactionManagement
@ComponentScan(basePackages = {
    "com.qldv"
//    "com.qldv.service"
})
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private AuthenticationSuccessHandler loginSuccessHandler;
    @Autowired
    private LogoutSuccessHandler logoutHandler;
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

   @Bean
    public Cloudinary cloudinary() {
        Cloudinary c = new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "dvsqhstsi",
                "api_key", "811136311528217",
                "api_secret", "W4hY0CZswRXzLwb5_FbRd7iOO7k",
                "secure", true
        ));
        return c;
    }
    
    @Bean
    public AuthenticationSuccessHandler loginSuccessHandler() {
       return new LoginSuccessHandler();
    }
    @Bean
    public LogoutSuccessHandler logoutHandler() {
        return new LogoutHandler();
    }
    
    
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder()); // Cách thức băm mật khẩu
    }
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        Cấu hình form login
        http.formLogin().loginPage("/login")
                .usernameParameter("username")
                .passwordParameter("password");
//        Cấu hình login thành công hay thất bại
        http.formLogin().defaultSuccessUrl("/").failureUrl("/login?error");
        http.formLogin().successHandler(this.loginSuccessHandler);
//        Cấu hình logout
        //http.logout().logoutSuccessUrl("/login");
        http.logout().logoutSuccessHandler(this.logoutHandler);
//        Cấu hình khi ngoại lệ
        http.exceptionHandling().accessDeniedPage("/login?accessDenied");
//        Phân quyền
        http.authorizeRequests().antMatchers("/").permitAll()
               .antMatchers("/admin/**").access("hasAuthority('Admin')");
         http.authorizeRequests().antMatchers("/tickets/**").access("hasAnyAuthority('Employee', 'Admin')");
          
        http.csrf().disable();
    }
    
    
    
}
