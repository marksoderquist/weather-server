package net.soderquist.mark.weather;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@WebAppConfiguration
@AutoConfigureMockMvc
public class WeatherRestControllerTest {

	@Autowired
	private WebApplicationContext context;

	@Autowired
	protected MockMvc mvc;

	@BeforeEach
	public void setup() {
		mvc = MockMvcBuilders.webAppContextSetup( context ).build();
	}

	@Test
	public void testGetWeatherInfo() throws Exception {
		// when
		MvcResult result = mvc.perform( get( "/station?id=bluewing" ).contentType( MediaType.APPLICATION_JSON ) ).andExpect( status().isOk() ).andReturn();

		// then
		assertThat( result.getResponse().getContentAsString() ).contains( "\"id\":\"bluewing\"" );
	}

	@Test
	public void testPutWeatherInfo() throws Exception {
		// given
		String body = "{\"unitSystem\":\"IMPERIAL\",\"temperature\":72.0,\"humidity\":0.5,\"windSpeed\":5.0,\"windDirection\":181.2}";

		// when
		MvcResult result = mvc.perform( put( "/station?id=bluewing" ).contentType( MediaType.APPLICATION_JSON ).content( body ) ).andExpect( status().isOk() ).andReturn();

		// then
		assertThat( result.getResponse().getContentAsString() ).contains( "\"windDirection\":181.2" );
	}

}
