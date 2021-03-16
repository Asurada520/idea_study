package com.ybzbcq.configuration;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

@Configuration
public class CustomMvcConfiguration implements InitializingBean {

	@Autowired
	private RequestMappingHandlerMapping requestMappingHandlerMapping;

	@Override
	public void afterPropertiesSet() throws Exception {
		requestMappingHandlerMapping.setRemoveSemicolonContent(false);
	}
}