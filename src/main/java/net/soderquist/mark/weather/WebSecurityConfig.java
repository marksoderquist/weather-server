package net.soderquist.mark.weather;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Override
	protected void configure( HttpSecurity http ) throws Exception {
		http.csrf().disable().authorizeRequests().antMatchers( HttpMethod.GET, "/station" ).permitAll().antMatchers( HttpMethod.PUT, "/station" ).authenticated().and().httpBasic();
	}

	@Autowired
	public void configureGlobal( AuthenticationManagerBuilder auth ) throws Exception {
		auth.inMemoryAuthentication().withUser( "dalton" ).password( "Do5JpMo8z5hSxUi4" ).roles( "USER" );
	}
}
