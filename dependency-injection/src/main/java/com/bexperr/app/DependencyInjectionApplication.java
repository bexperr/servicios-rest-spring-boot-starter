package com.bexperr.app;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.bexperr.app.atributo.*;
import com.bexperr.app.profiles.EnviromentService;
import com.bexperr.app.scopes.EjemploScopes;

import com.bexperr.app.lifecycle.LifeCycleBean;
import com.bexperr.app.aop.TargetObject;

@SpringBootApplication
public class DependencyInjectionApplication {
	
	private static final Logger log = LoggerFactory.getLogger(DependencyInjectionApplication.class);

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(DependencyInjectionApplication.class, args);
		TargetObject tarjetObject = context.getBean(TargetObject.class);
		tarjetObject.hello("Hello World");
		
	}

}
