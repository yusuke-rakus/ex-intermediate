package com.example.demo.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.Service.HotelService;

@Controller
@RequestMapping("/search")
public class HotelController {
	
	@Autowired
	private HotelService service;
	
	@RequestMapping("")
	public String index() {
		return "ex02/search";
	}
	
	@RequestMapping("/submit")
	public String submit(Integer price, Model model) {
		if(price == null) {
			model.addAttribute("hotelList", service.findAll());
			return "ex02/search";
		}
		model.addAttribute("hotelList", service.findByPriceBelow(price));
		return "ex02/search";
	}

}
