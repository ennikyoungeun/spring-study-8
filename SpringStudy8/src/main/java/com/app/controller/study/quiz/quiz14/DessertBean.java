package com.app.controller.study.quiz.quiz14;

import lombok.Data;

@Data
public class DessertBean {

	String name;
	
	public DessertBean(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
}
