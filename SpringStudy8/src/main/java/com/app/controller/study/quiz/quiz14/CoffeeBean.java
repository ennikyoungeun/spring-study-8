package com.app.controller.study.quiz.quiz14;

import lombok.Data;

@Data
public class CoffeeBean {
	
	String name;
	
	public CoffeeBean(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}

}
