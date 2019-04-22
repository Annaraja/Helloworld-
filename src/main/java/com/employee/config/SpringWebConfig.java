package com.employee.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;


@EnableWebMvc
@Configuration
@ComponentScan({"com.employee.controller","com.employee.validator"})
@Import({ServiceConfig.class,
		DaoConfig.class})
public class SpringWebConfig extends WebMvcConfigurerAdapter{

	
	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/views/jsp/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}
//	@Bean
//	public ResourceBundleMessageSource messageSource() {
//		ResourceBundleMessageSource rb = new ResourceBundleMessageSource();
//		rb.setBasenames(new String[] { "messages/messages", "messages/validation" });
//		return rb;
//	}
	
	@Bean
	public MessageSource messageSource(){
		ReloadableResourceBundleMessageSource source= new ReloadableResourceBundleMessageSource();
		source.setBasename("/WEB-INF/messages/messages");
		return source;
	}
	
	
}
