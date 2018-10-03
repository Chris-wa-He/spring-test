package com.chris.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.chris.interceptor.DemoInterceptor;
import com.chris.interceptor.DemoInterceptorWithInterface;

@Configuration
@EnableWebMvc
@ComponentScan("com.chris")
public class MyMvcConfig extends WebMvcConfigurerAdapter {

	@Bean
	public InternalResourceViewResolver viewResolver() {

		InternalResourceViewResolver resourceViewResolver = new InternalResourceViewResolver();

		resourceViewResolver.setPrefix("/WEB-INF/classes/views/");
		resourceViewResolver.setSuffix(".jsp");
		resourceViewResolver.setViewClass(JstlView.class);

		return resourceViewResolver;

	}

	@Bean
	public DemoInterceptor demoInterceptor() {
		return new DemoInterceptor();
	}

	@Bean
	public DemoInterceptorWithInterface demoInterceptorWithInterface() {
		return new DemoInterceptorWithInterface();

	}

	@Bean
	public MultipartResolver MultipartResolver() {
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
		multipartResolver.setMaxUploadSize(1000000);
		return multipartResolver;
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/assets/**").addResourceLocations("classpath:/assets/");
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(demoInterceptorWithInterface());
		registry.addInterceptor(demoInterceptor());
	}

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/index").setViewName("index");
		registry.addViewController("/toUpload").setViewName("upload");

	}

}
