/**
 * 
 */
package com.sivalabs.buzz.web.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.security.config.annotation.authentication.builders.*;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.*;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
//@EnableWebSecurity
@EnableWebMvcSecurity 
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private CustomUserDetailsService customUserDetailsService;
	
	@Bean
	public PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}
	
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
        	.userDetailsService(customUserDetailsService)
        	.passwordEncoder(passwordEncoder());
        
        /*  auth  .inMemoryAuthentication()
                .withUser("admin@gmail.com").password("admin").roles("ADMIN","USER").and()
                .withUser("siva@gmail.com").password("siva").roles("USER");
          */
    }
    
    protected void configure(HttpSecurity http) throws Exception {
        http
        	//.csrf().disable()
            .authorizeRequests()
            	.antMatchers("/resources/**", "/login", "/register","/forgotPwd","/resetPwd").permitAll()  
            	.antMatchers("/admin","/admin/**").hasRole("ADMIN")
                .anyRequest().authenticated()
                .and()
            .formLogin()
                .loginPage("/login") 
                .permitAll();
    }
}
