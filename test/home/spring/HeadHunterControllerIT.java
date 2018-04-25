package home.spring;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.net.URL;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HeadHunterControllerIT
{
	@LocalServerPort
	private int port;

	private URL base;

	@Autowired
	private TestRestTemplate template;

	@Before
	public void setUp() throws Exception
	{
		this.base = new URL( "http://localhost:" + port );
	}

	@Test
	public void getHello() throws Exception
	{
		ResponseEntity<String> response = template.getForEntity( base.toString() + "/hello", String.class );
		assertThat( response.getBody(), equalTo( "Greetings from Spring Boot!" ) );
	}

	@Test
	public void getHunters100() throws Exception
	{
		ResponseEntity<String> response = template.getForEntity( base.toString() + "/head-hunters/100", String.class );
		//		String json = "[{\"id\":1,\"name\":\"ABC Test\"},{\"id\":2,\"name\":\"TUV Test\"},{\"id\":3,\"name\":\"KLM Test\"},{\"id\":4,\"name\":\"PQR Test\"},{\"id\":5,\"name\":\"XYZ Test\"}]";
		String json = "[{\"id\":100,\"name\":\"Rajasthan Royals\"}]";
		assertThat( response.getBody(), equalTo( json ) );
	}
}

