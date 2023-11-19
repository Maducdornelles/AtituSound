package br.edu.atitus.atitusound.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class ConfigSecurity {

	private final AuthTokenFilter authtokenFilter;
	
	public ConfigSecurity(AuthTokenFilter authtokenFilter) {
		super();
		this.authtokenFilter = authtokenFilter;
	}

	@Bean
	public SecurityFilterChain getFilterChain(HttpSecurity http) throws Exception {
		http
			.csrf(csrf -> csrf.disable())
			.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
			.authorizeHttpRequests(auth -> auth
					.requestMatchers("/auth/**","/swagger-ui*","swagger-ui/**","/v3/api-docs/**").permitAll()
					.anyRequest().authenticated())
			.addFilterBefore(authtokenFilter, UsernamePasswordAuthenticationFilter.class);
		return http.build();
		
	}
	
}
