package com.chris.aware;

import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

@Service
public class DemoAwareService implements BeanNameAware, ResourceLoaderAware {

	private String beanName;
	private ResourceLoader resourceLoader;

	@Override
	public void setResourceLoader(ResourceLoader resourceLoader) {
		this.resourceLoader = resourceLoader;

	}

	@Override
	public void setBeanName(String name) {
		this.beanName = name;

	}

	public void outputResult() {

		System.out.println("Bean name:" + this.beanName);

		Resource resource = resourceLoader.getResource("classpath:aware-source/aware.txt");

		try {
			System.out.println(
					"File context was loaded by resource loader:" + IOUtils.toString(resource.getInputStream()));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
