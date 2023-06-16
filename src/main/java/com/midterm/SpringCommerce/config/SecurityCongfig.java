package com.midterm.SpringCommerce.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity
public class SecurityCongfig {

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public UserDetailsService userDetailService() {
		
		UserDetails normalUser = User.withUsername("vuluan").password(passwordEncoder().encode("123456"))
				.roles("MEMBER").build();
		
		UserDetails normalUser2 = User.withUsername("test").password(passwordEncoder().encode("test"))
				.roles("MEMBER").build();
		
		UserDetails adminUser = User.withUsername("admin").password(passwordEncoder().encode("admin")).roles("ADMIN")
				.build();

		return new InMemoryUserDetailsManager(normalUser, adminUser, normalUser2);
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.authorizeHttpRequests().requestMatchers("/", "/brand/*", "/category/*","/product" ,"/product/*", "/css/**","/js/**", "/images/**", "/image/*").permitAll()
				.anyRequest().authenticated().and().formLogin().and().exceptionHandling()
				  .accessDeniedPage("/access-denied");;

		return httpSecurity.build();
	}
}