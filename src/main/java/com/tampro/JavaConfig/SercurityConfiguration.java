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
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
@Order(1)
public class SercurityConfiguration extends  WebSecurityConfigurerAdapter {
	
	@Autowired
	DataSource dataSource;
	
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(dataSource).usersByUsernameQuery("select username,password,ENABLED from user where username = ?")
		.authoritiesByUsernameQuery("select username,role from user where username = ?");
		
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED);
		// chi tao ra session khi yeu cau
		
		/*http.csrf().disable().antMatcher("/user/**").authorizeRequests().anyRequest().hasRole("USER")
		.and().formLogin().loginPage("/login").loginProcessingUrl("/user/dang-nhap").defaultSuccessUrl("/home").failureUrl("/login")
		.and().exceptionHandling().accessDeniedPage("/login");
		*/
		
		http.csrf().disable().antMatcher("/user/**").authorizeRequests().antMatchers("/user/**").hasRole("USER").and().formLogin()
		.loginPage("/login").loginProcessingUrl("/user/dang-nhap")
		.defaultSuccessUrl("/home").failureUrl("/login?err=loginfailed")
		.and().exceptionHandling().accessDeniedPage("/login");
	}
		

	
	@Override
	public void configure(WebSecurity web) throws Exception {
		// TODO Auto-generated method stub
		web.ignoring().antMatchers("/resource/**");
	}

}

	
	

