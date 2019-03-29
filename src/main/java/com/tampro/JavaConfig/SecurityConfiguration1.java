package com.tampro.JavaConfig;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration
@Order(2)
public class SecurityConfiguration1  extends WebSecurityConfigurerAdapter{
	
	@Autowired
	DataSource dataSource;
	
     @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    	 auth.jdbcAuthentication().dataSource(dataSource).usersByUsernameQuery("select username,password,ENABLED from user where username = ?")
 		.authoritiesByUsernameQuery("select username,role from user where username = ?");
    }
     @Override
    protected void configure(HttpSecurity http) throws Exception {


		
		http.csrf().disable().authorizeRequests().antMatchers("/admin/**").hasRole("ADMIN")
		 .and().formLogin()
		.loginPage("/login-admin").loginProcessingUrl("/admin/dang-nhap")
		.defaultSuccessUrl("/admin/home").failureUrl("/login-admin?err=loginfailed")
		.and().exceptionHandling().accessDeniedPage("/login-admin");
		
    }
     @Override
 	public void configure(WebSecurity web) throws Exception {
 		// TODO Auto-generated method stub
 		web.ignoring().antMatchers("/resource/**");
 	}

}
