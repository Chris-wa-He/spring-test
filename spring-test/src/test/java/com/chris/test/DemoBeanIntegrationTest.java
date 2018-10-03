package com.chris.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { TestConfig.class })
@ActiveProfiles("prod")
public class DemoBeanIntegrationTest {

	@Autowired
	private TestBean testBean;

	@Test
	public void testBeanInjected() {

		String expected = "From prod profile";

		Assert.assertEquals(expected, testBean.getContent());
	}

}
