package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.Service.ShoppingService;

@Controller
@RequestMapping("/shopping")
public class ShoppingaController {
	
	@Autowired
	private ShoppingService shoppingService;
	
	@RequestMapping("")
	public String index() {
		return "ex03/home";
	}

}
