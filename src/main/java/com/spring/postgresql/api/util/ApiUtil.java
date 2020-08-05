package com.spring.postgresql.api.util;

import java.io.IOException;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.postgresql.api.model.NewCustomer;


@Component
@PropertySource(value = "classpath:application.properties")
public class ApiUtil {
	@Autowired
	private RestTemplate template;

	HttpHeaders headers = null;
	ObjectMapper mapper = null;
	@Autowired
	private Environment env;

	@PostConstruct
	public void init() {
		headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		mapper = new ObjectMapper();
	}

	public Long registerNewCustomer(NewCustomer customer) {
		Long response = null;
		String jsonRequest = null;
		String result = "";
		String URL = "";
		try {
			URL = env.getProperty("registration.url");
			jsonRequest = mapper.writeValueAsString(customer);
			HttpEntity<String> entity = new HttpEntity<String>(jsonRequest, headers);
			result = template.postForObject(URL, entity, String.class);
			response = mapper.readValue(result, Long.class);
		} catch (IOException e) {
			System.out.println("ERROR : " + e.getMessage());
		}

		return response;

	}

	public NewCustomer retrieveByEmail(String email) {
		NewCustomer response = null;
		String result = "";
		String URL = "";
		String request = "{\r\n" + 
				"findCustomer(email:\""
				+ email
				+ "\"){\r\n" + 
				"id\r\n" + 
				"name\r\n" + 
				"}\r\n" + 
				"}";
		try {
			URL = env.getProperty("retrieve.url");
			HttpEntity<String> entity = new HttpEntity<String>(request, headers);
			result = template.postForObject(URL, entity, String.class);
			response = mapper.readValue(result, NewCustomer.class);
		} catch (IOException e) {
			System.out.println("ERROR : " + e.getMessage());
		}

		return response;

	}
	
}
