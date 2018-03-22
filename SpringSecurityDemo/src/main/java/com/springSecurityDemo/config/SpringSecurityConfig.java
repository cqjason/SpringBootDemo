package com.springSecurityDemo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Created by Jason on 2018/3/19.
 */
@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter{

    /*@Bean
    UserDetailsService customUserService(){
        return new CustomUserService();
    }*/

    /**
     * 自定义配置
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception{

        http.authorizeRequests()
                .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers("/index").permitAll()
                .and().formLogin().loginPage("/login").failureUrl("/login-error");
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
        auth
                .inMemoryAuthentication()
                .withUser("admin").password("123456").roles("ADMIN");
        auth
                .inMemoryAuthentication()
                .withUser("user").password("123456").roles("USER");
    }

}
