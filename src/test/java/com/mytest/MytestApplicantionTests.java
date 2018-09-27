package com.mytest;

import java.util.Arrays;

import javax.xml.bind.DatatypeConverter;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import com.mytest.MytestApplication;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MytestApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MytestApplicantionTests {
	@LocalServerPort
	private int port;

	String username = "mytestuser";
	String password = "secret123";

	TestRestTemplate restTemplate = new TestRestTemplate();

	HttpHeaders headers = new HttpHeaders();
	String authorizationHeader = "Basic " + DatatypeConverter.printBase64Binary((username + ":" + password).getBytes());
	HttpEntity<String> entity;
	
	@Before
	public void setup() throws Exception {
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.add("Authorization", authorizationHeader);

		entity = new HttpEntity<String>(null, headers);
	}

	@Test
	public void contextLoads() {
		
	}

	@Test
	public void testRetrieveUsers() {

		ResponseEntity<String> response = restTemplate.exchange(createURLWithPort("/api/user"), HttpMethod.GET, entity,
				String.class);

		String expected = "[{userid:gosankar,firstName:Govind,lastName:Sankar},{userid:one,firstName:FirstOne,lastName:LastOne},{userid:two,firstName:FirstTwo,lastName:LastTwo}]";

		JSONAssert.assertEquals(expected, response.getBody(), false);
	}
	
	@Test
	public void testRetrieveUser() {

		ResponseEntity<String> response = restTemplate.exchange(createURLWithPort("/api/user/gosankar"), HttpMethod.GET, entity,
				String.class);

		String expected = "{userid:gosankar,firstName:Govind,lastName:Sankar}";

		JSONAssert.assertEquals(expected, response.getBody(), false);
	}

	private String createURLWithPort(String uri) {
		return "http://localhost:" + port + uri;
	}

}
