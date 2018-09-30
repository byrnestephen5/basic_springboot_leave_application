package com.byrne.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.byrne.demo.dao.TeamMemberRepo;

import com.byrne.demo.model.TeamMember;

@Controller
public class TeamMemberController {
	@Autowired
	TeamMemberRepo repo;

		
	@RequestMapping(value = "/TeamMemberForm", method = RequestMethod.GET)
	public String TeamMemberForm() {

		return "TeamMemberForm";
	}

	//Maps to action in form	
	@RequestMapping(value = "/addTeamMember", method = RequestMethod.POST)
	public String addTeamMember(TeamMember teammember) {
		repo.save(teammember);
		return "TeamMemberForm";
	}



	@RequestMapping(value ="/editMembers", method = RequestMethod.GET)
	public String showPage(Model model,@RequestParam(defaultValue="0") int page) {
		model.addAttribute("data", repo.findAll(PageRequest.of(page, 20)));
		model.addAttribute("currentPage", page);

		return"editMembers";
	}		


	@PostMapping("/save")
	public String save(TeamMember tm) {
		repo.save(tm);

		return "redirect:/editMembers";
	}

	@GetMapping("/delete")
	public String deleteTeamMember(String id) {
		repo.deleteById(id);;

		return "redirect:/editMembers";
	}

	@GetMapping("/findOne")
	@ResponseBody
	public Optional<TeamMember> findOne(String id) {
		return repo.findById(id);

	}


}
