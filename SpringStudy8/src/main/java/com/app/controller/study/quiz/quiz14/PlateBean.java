package com.app.controller.study.quiz.quiz14;

import lombok.Data;

@Data
public class PlateBean {
	
	DessertBean dessertBean;
	
	public PlateBean(DessertBean dessertBean) {
		this.dessertBean =dessertBean;
	}
	
	public DessertBean getDessertBean() {
		return dessertBean;
	}

}
