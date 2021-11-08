package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Domain.Hotel;
import com.example.demo.Repository.HotelRepository;

@Service
public class HotelService {
	
	@Autowired
	private HotelRepository repository;
	
	public List<Hotel> findByPriceBelow(Integer price) {
		return repository.findByPriceBelow(price);
	}
	
	public List<Hotel> findAll(){
		return repository.findAll();
	}

}
