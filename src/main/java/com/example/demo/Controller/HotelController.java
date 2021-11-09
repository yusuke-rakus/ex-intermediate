package com.example.demo.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.Service.HotelService;
import com.example.demo.form.HotelForm;

@Controller
@RequestMapping("/search")
public class HotelController {
	
	@ModelAttribute
	public HotelForm setUpForm() {
		return new HotelForm();
	}
	
	@Autowired
	private HotelService service;
	
	/** 検索画面トップにアクセスした場合のルーティング */
	@RequestMapping("")
	public String index() {
		return "ex02/search";
	}
	
	/** 検索ボタンをクリックした場合のルーティング */
	@RequestMapping("/submit")
	public String submit(@Validated HotelForm form, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "ex02/search";
		}
		// priceがnullだった場合の処理
		if(form.getPrice() == null) {
			model.addAttribute("hotelList", service.findAll());
			return "ex02/search";
		}
		// price以下のhotelListを取得
		model.addAttribute("hotelList", service.findByPriceBelow(form.getPrice()));
		return "ex02/search";
	}

}
