package com.chris.ELservice;

import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;

@Configuration
@ComponentScan("com.chris.ELservice")
@PropertySource("classpath:EL-test-source/EL-test-properties.properties")
public class ElConfig {

	@Value("Normal String")
	private String normal;

	@Value("#{systemProperties['os.name']}")
	private String osName;

	@Value("#{ T(java.lang.Math).random() * 100.0}")
	private Double randomNumber;

	@Value("#{demoValueService.anotherValue}")
	private String fromAnother;

	@Value("classpath:EL-test-source/EL-test.txt")
	private Resource testFile;

	@Value("http://www.baidu.com/")
	private Resource testURL;

	@Value("${book.name}")
	private String bookname;

	@Autowired
	private Environment environment;

	@Bean
	private static PropertySourcesPlaceholderConfigurer propertyConfigure() {
		return new PropertySourcesPlaceholderConfigurer();

	}

	public void outputResoure() {

		try {
			System.out.println(normal);
			System.out.println(osName);
			System.out.println(randomNumber);
			System.out.println(fromAnother);

			System.out.println(IOUtils.toString(testFile.getInputStream()));
			System.out.println(IOUtils.toString(testURL.getInputStream()));
			System.out.println(bookname);
			System.out.println(environment.getProperty("book.author"));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
