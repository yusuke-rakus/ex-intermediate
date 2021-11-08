package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Domain.Team;
import com.example.demo.Repository.TeamRepository;

@Service
public class TeamService {
	
	@Autowired
	private TeamRepository repository;
	
	public List<Team> getTeamList(){
		return repository.getTeamList();
	}
	
	public Team findById(Integer id) {
		return repository.findById(id);
	}

}
