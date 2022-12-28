package net.soderquist.mark.weather;

import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.RequestMatcher;

import java.lang.invoke.MethodHandles;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

	private final Logger log = LoggerFactory.getLogger( MethodHandles.lookup().lookupClass() );

	@Bean
	protected SecurityFilterChain configure( HttpSecurity http ) throws Exception {
		http.csrf().ignoringRequestMatchers( request -> {
			log.info( request.getMethod() + " -> " + request.getServletPath() );
			return request.getMethod().equals( "PUT" ) && request.getServletPath().equals( "/station" );
		} );
		http.authorizeHttpRequests().requestMatchers(HttpMethod.GET, "/station").permitAll().requestMatchers( HttpMethod.PUT, "/station" ).authenticated().and().httpBasic( withDefaults() );
		return http.build();
	}

	@Autowired
	public void configureGlobal( AuthenticationManagerBuilder auth ) throws Exception {
		auth.inMemoryAuthentication().withUser( "dalton" ).password( "{noop}Do5JpMo8z5hSxUi4" ).roles( "USER" );
	}

}
