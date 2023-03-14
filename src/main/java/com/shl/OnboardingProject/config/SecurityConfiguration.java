package com.shl.OnboardingProject.config;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.shl.OnboardingProject.filters.JwtRequestFilter;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private  UserDetailsService userDetailsService;
	
	@Autowired
	private JwtRequestFilter jwtRequestFilter;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(userDetailsService);
	}
	
	@Override
    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//                .antMatchers("/create/**").hasRole("HR_ADMIN")
//                .antMatchers("/employees").hasAnyRole("HR_ADMIN", 
//                		"HR_PARTNER","EMPLOYEE")
//                .antMatchers("/edit/**")
//                .hasAnyRole("HR_ADMIN","HR_PARTNER","EMPLOYEE")
//                .antMatchers("/salary/**")
//                .hasRole("HR_ADMIN")
//                .antMatchers("/authenticate").permitAll()
//                .antMatchers("/").permitAll()
//                .and().formLogin();
//		http.authorizeRequests()
//			.antMatchers("/**")
//			.permitAll().and().formLogin();
		http.csrf().disable()
			.authorizeRequests()
			.antMatchers("/employees").hasRole("HR_ADMIN")
			.antMatchers("/employees/create").hasRole("HR_ADMIN")
			.antMatchers("/hr-admins/create").hasRole("HR_ADMIN")
			.antMatchers("/hr-partners/create").hasRole("HR_ADMIN")
			.antMatchers("/super-admins/create").hasRole("HR_ADMIN")
			.antMatchers("/").permitAll()
			.antMatchers("/authenticate").permitAll()
			.anyRequest().authenticated()
			.and().sessionManagement()
			.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
    }
	
	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception{
		return super.authenticationManagerBean();
	}
	
	@Bean 
	public PasswordEncoder getPasswordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
}
