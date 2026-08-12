package com.app.controller.study.quiz.quiz14;

import lombok.Data;

@Data
public class CupBean {
	CoffeeBean coffeeBean;
	
	public CupBean(CoffeeBean coffeeBean) {
		this.coffeeBean =coffeeBean;
	}
	
	public CoffeeBean getCoffeeBean() {
		return coffeeBean;
	}
	

}
