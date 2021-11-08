package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.Domain.Team;
import com.example.demo.Service.TeamService;

@Controller
@RequestMapping("/")
public class TeamController {
	
	@Autowired
	private TeamService service;
	
	@RequestMapping("")
	public String index(Model model) {
		List<Team> teamList = service.getTeamList();
		model.addAttribute("teamList", teamList);
		return "team-list";
	}
	
	@RequestMapping("/showDetail")
	public String showDetail(Integer id, Model model) {
		Team team = service.findById(id);
		model.addAttribute("team", team);
		
		return "team-detail";
	}
	
	@RequestMapping("/back")
	public String back() {
		return "redirect:/";
	}

}
