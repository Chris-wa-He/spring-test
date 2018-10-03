package com.chris.test.example;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import com.chris.test.dao.PersonRepository;
import com.chris.test.domain.Person;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
@Transactional
public class SampleTest {

	@Autowired
	private PersonRepository personRepository;

	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext webApplicationContext;

	private String expectedJson;

	@Before
	public void setup() throws JsonProcessingException {
		Person p1 = new Person("test1");
		Person p2 = new Person("test2");
		personRepository.save(p1);
		personRepository.save(p2);

		expectedJson = obj2Json(personRepository.findAll());

		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	protected String obj2Json(Object object) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		return mapper.writeValueAsString(object);
	}

	@Test
	public void testPersonController() throws Exception {
		String uri = "/person/findAll";

		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON_VALUE))
				.andReturn();

		int status = result.getResponse().getStatus();
		String content = result.getResponse().getContentAsString();

		Assert.assertEquals("Error! Return code should be 200.", 200, status);
		Assert.assertEquals("Error! Return result does not match expected.", expectedJson, content);
	}
}
