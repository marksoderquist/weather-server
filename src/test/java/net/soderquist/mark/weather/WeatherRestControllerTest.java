package net.soderquist.mark.weather;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class WeatherRestControllerTest {

	@Autowired
	protected MockMvc mvc;

	@Test
	public void testGetWeatherInfo() throws Exception {
		MvcResult result = mvc.perform( get( "/station?id=bluewing" ).contentType( MediaType.APPLICATION_JSON ) ).andExpect( status().isOk() ).andReturn();
		System.out.println( result.getResponse().getContentAsString() );
	}

}
