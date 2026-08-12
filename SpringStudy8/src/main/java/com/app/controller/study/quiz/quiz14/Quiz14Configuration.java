package com.app.controller.study.quiz.quiz14;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Quiz14Configuration {

	//Bean 등록설정
	@Bean
	public CoffeeBean coffeeBean() {
		return new CoffeeBean("민트초코프라페");
	}
	@Bean
	public CupBean cupBean() {
		return new CupBean(coffeeBean());
	}
	
	@Bean
	public DessertBean dessertBean() {
		return new DessertBean("당근케이크");
	}
	@Bean
	public PlateBean plateBean() {
		return new PlateBean(dessertBean());
	}
	
	
}
