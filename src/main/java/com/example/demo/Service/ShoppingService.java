package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Domain.Shopping;
import com.example.demo.Repository.ShoppingRepository;

@Service
public class ShoppingService {
	
	@Autowired
	private ShoppingRepository shoppingRepository;
	
	public List<Shopping> findByGenderAndColor(Integer gender, String color) {
		return shoppingRepository.findByGenderAndColor(gender, color);
	}
	
}
