package com.bexperr.app.lifecycle;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.slf4j.Logger;

@Component
//@Scope("prototype") -- Recoerdemos que predestroy no se ejecuta para beans de tipo prototype
public class LifeCycleBean implements BeanNameAware, InitializingBean, DisposableBean {
	
	private static final Logger log = LoggerFactory.getLogger(LifeCycleBean.class);

	/**
	 * Ejecucion durante la construccion del bean "BeanNameAware"
	 */
	@Override
	public void setBeanName(String name) {
		log.info("Bean name {}", name);
	}
	
	/**
	 * Se ejecutara despues de la inyeccion de dependencias
	 */
	@PostConstruct
	public void init() { 
		log.info("PostConstruct");
	}
	
	/**
	 * Se ejecutara antes de que el bean sea destruido
	 * No se ejecutan para beans prototype
	 * Solo se ejecutan durante una terminacion de la VM de forma normal
	 */
	@PreDestroy
	public void destroy() {
//		log.info("PreDestroy");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		
	}

}
