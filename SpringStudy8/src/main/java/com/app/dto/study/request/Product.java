package com.app.dto.study.request;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

//@Getter
//@Setter
//@ToString

//한번에 처리하고 싶을때.
@Data
public class Product {
	
	public String id;
	public String name;
	public int price;
	public String type;
	
}