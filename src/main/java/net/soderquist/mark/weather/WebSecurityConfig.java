package net.soderquist.mark.weather;

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
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import java.lang.invoke.MethodHandles;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

	public static final String STATION_PATH = "/station";

	private final Logger log = LoggerFactory.getLogger( MethodHandles.lookup().lookupClass() );

	@Bean
	protected SecurityFilterChain configure( HttpSecurity http ) throws Exception {
		return http
			.csrf( requests -> requests.ignoringRequestMatchers( new AntPathRequestMatcher( STATION_PATH ) ) )
			.authorizeHttpRequests( requests -> requests.requestMatchers( HttpMethod.GET, STATION_PATH ).permitAll().requestMatchers( HttpMethod.PUT, STATION_PATH ).authenticated() )
			.httpBasic( requests -> {} )
			.build();
	}

	@Autowired
	public void configureGlobal( AuthenticationManagerBuilder auth ) throws Exception {
		auth.inMemoryAuthentication().withUser( "dalton" ).password( "{noop}Do5JpMo8z5hSxUi4" ).roles( "USER" );
	}

}
