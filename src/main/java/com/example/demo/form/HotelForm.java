package com.example.demo.form;

import org.hibernate.validator.constraints.Range;

public class HotelForm {
	
	@Range(min=0, max=300000, message="0から300,000までで入力してください")
	private Integer price;

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "HotelForm [price=" + price + "]";
	}
	

}
