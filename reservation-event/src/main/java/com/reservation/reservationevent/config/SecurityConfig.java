package com.reservation.reservationevent.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties;
import org.springframework.boot.autoconfigure.security.reactive.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.RequestCacheConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.token.TokenService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.header.writers.frameoptions.XFrameOptionsHeaderWriter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.reservation.reservationevent.handler.LoginSuccessHandler;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	AuthenticationManager authenticationManager;

	@Bean
	public UserDetailsManager userDetailsManager() {
		UserDetails user = User.builder()
			.passwordEncoder(passwordEncoder()::encode)
			.username("member1")
			.password("123")
			.roles("MEMBER")
			.build();

		UserDetails user2 = User.builder()
			.passwordEncoder(passwordEncoder()::encode)
			.username("admin")
			.password("123")
			.roles("ADMIN")
			.build();

		UserDetails user3 = User.builder()
			.passwordEncoder(passwordEncoder()::encode)
			.username("member2")
			.password("123")
			.roles("MEMBER")
			.build();

		UserDetails user4 = User.builder()
			.passwordEncoder(passwordEncoder()::encode)
			.username("member3")
			.password("123")
			.roles("MEMBER")
			.build();
		return new InMemoryUserDetailsManager(user, user2, user3, user4);
	}



	@Bean
	PasswordEncoder passwordEncoder() {
		return Pbkdf2PasswordEncoder.defaultsForSpringSecurity_v5_8();
	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		// AuthenticationManagerBuilder authenticationManagerBuilder = http.getSharedObject(AuthenticationManagerBuilder.class);
		// authenticationManagerBuilder.userDetailsService(userDetailsManager());
		// authenticationManager = authenticationManagerBuilder.build();

		// http
		// 	.csrf().disable()
		// 	.cors().and()
		// 	.authorizeHttpRequests()
		// 	// .requestMatchers("/admin").hasRole("ADMIN")
		// 	.anyRequest().authenticated()
		// 	.and()
		// 	.authenticationManager(authenticationManager);
			// .formLogin()
			// .successHandler(successHandler());
		// http.authenticationManager(new CustomAuthenticationManager());
		return http.build();
	}

	// @Bean
	// public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
	// 	// http.authorizeHttpRequests()
	// 	// 	.requestMatchers("/admin/").hasRole("ADMIN")
	// 	// 	.requestMatchers("/member/").hasRole("MEMBER")
	// 	// 	.anyRequest().permitAll()
	// 	// 	.and()
	// 	// 	.csrf()
	// 	// 	.ignoringRequestMatchers(
	// 	// 		new AntPathRequestMatcher("/h2-console/**")
	// 	// 	).and()
	// 	// 	.headers()
	// 	// 	.addHeaderWriter(new XFrameOptionsHeaderWriter(
	// 	// 		XFrameOptionsHeaderWriter.XFrameOptionsMode.SAMEORIGIN)
	// 	// 	)
	// 	// 	.and()
	// 	// 	.formLogin()
	// 	// 	.defaultSuccessUrl("/")
	// 	// 	.successHandler(successHandler());
	//
	// 	// http.authorizeHttpRequests()
	// 	// 	// .requestMatchers("/login").permitAll()
	// 	// 	// .requestMatchers("/admin").hasRole("ADMIN")
	// 	// 	// .requestMatchers("/member").hasRole("MEMBER")
	// 	// 	.anyRequest().authenticated()
	// 	// 	.and()
	// 	// 	.formLogin()
	// 	// 	// .permitAll()
	// 	// 	.defaultSuccessUrl("/");
	// 	//
	// 	// http.csrf().disable();
	// 	//
	// 	// return http.build();
	//
	//
	//
	// 	//  http.authorizeHttpRequests()
	// 	// 		 .anyRequest().authenticated();
	// 	//
	// 	// http.formLogin();
	// 	//
	// 	//
	// 	// return http.build();
	//
	// 	// http.authorizeHttpRequests((authz) -> authz.anyRequest().authenticated())
	// 	// 	.httpBasic(Customizer.withDefaults());
	//
	//
	//
	// 	http.authorizeHttpRequests()
	// 		.requestMatchers("/member")
	// 		.hasRole("MEMBER")
	// 		.requestMatchers("/")
	// 		.permitAll()
	// 		.anyRequest().authenticated();
	//
	// 	http.formLogin()
	// 		.successHandler(successHandler());
	//
	// 	return http.build();
	//
	//
	// }

	// @Bean
	// public WebSecurityCustomizer webSecurityCustomizer() {
	// 	return (web) -> web.ignoring().requestMatchers("/ignore1");
	// }

	@Bean
	public AuthenticationSuccessHandler successHandler() {
		return new LoginSuccessHandler();
	}
	//

	//
	// @Bean
	// public void configureGlobal(AuthenticationManagerBuilder auth)
	// 	throws Exception {
	// 	auth.inMemoryAuthentication().withUser("member")
	// 		.password(encodePassword().encode("member")).roles("MEMBER");
	// }

	// @Bean
	// public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
	// 	return authenticationConfiguration.getAuthenticationManager();
	// }

	// @Bean
	// public InMemoryUserDetailsManager userDetailsManager() {
	// 	UserDetails user = User.builder()
	// 		.passwordEncoder(encodePassword()::encode)
	// 		.username("member")
	// 		.password("member")
	// 		.roles("MEMBER")
	// 		.build();
	//
	// 	return new InMemoryUserDetailsManager(user);
	// }

	// @Bean
	// public InMemoryUserDetailsManager inMemoryUserDetailsManager() {
	// 	return new InMemoryUserDetailsManager();
	// }
	//
	// @Bean
	// public UserDetailsService userDetailsManager(AuthenticationManagerBuilder auth) throws Exception {
	//
	// 	auth.inMemoryAuthentication()
	// 		.withUser("member").password("member").roles("MEMBER");
	//
	// 	// InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
	// 	//
	// 	// manager.createUser(User.withUsername("member")
	// 	// 	.password(bCryptPasswordEncoder.encode("member"))
	// 	// 	.roles("MEMBER")
	// 	// 	.build());
	// 	// // UserDetails user = User.builder()
	// 	// // 	.passwordEncoder(encodePassword()::encode)
	// 	// // 	.username("member")
	// 	// // 	.password("member")
	// 	// // 	.roles("ADMIN")
	// 	// // 	.build();
	// 	//
	// 	// return manager;
	// }

	// @Bean
	// public AuthenticationManager authenticationManager(HttpSecurity http, BCryptPasswordEncoder bCryptPasswordEncoder, UserDetailsService userDetailService)
	// 	throws Exception {
	// 	return http.getSharedObject(AuthenticationManagerBuilder.class)
	// 		.userDetailsService(userDetailService)
	// 		.passwordEncoder(bCryptPasswordEncoder)
	// 		.and()
	// 		.build();
	// }

	@Bean
	public WebSecurityCustomizer webSecurityCustomizer() {
		// 정적 자원에 스프링 시큐리티 필터 규칙을 적용하지 않도록 설정
		return (web) -> web.ignoring().requestMatchers(
			String.valueOf(PathRequest.toStaticResources().atCommonLocations()));
	}

}
