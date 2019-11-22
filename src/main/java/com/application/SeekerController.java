package com.application;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.models.Seeker;
import com.services.SeekerService;


@Controller
public class SeekerController {

private final SeekerService seekerService;
	
	public SeekerController(SeekerService seekerService)
	{
		this.seekerService = seekerService;
	}
	
	@GetMapping("/seeker.html")
	public String getBloodBankList(Model model) {
		model.addAttribute("seekers",seekerService.getSeekerList());
		return "seeker/list";
	}
	
	@RequestMapping("/seeker/create.html")
	public String create(Model model) {
		return "seeker/create";
	}
	
	@PostMapping("/seeker/search.html")
	public String search(Model model, HttpServletRequest  request) {
		String search = request.getParameter("search");
		model.addAttribute("seekers",seekerService.search(search));
		return "seeker/list";
	}
	
	@GetMapping(value="/seeker.html", params="seekerId")
	public String getSeeker(@RequestParam("seekerId") String seekerId, Model model) {
		try {
			Seeker seeker = seekerService.getSeeker(Integer.parseInt(seekerId));
			model.addAttribute("seeker", seeker);
			return "seeker/details";
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}		
	}
	
	@PostMapping(value="/seeker.html/delete", params="seekerId")
	public String deleteSeeker(@RequestParam("seekerId") String seekerId, Model model) {
		try {
			seekerService.deleteSeeker(Integer.parseInt(seekerId));
			model.addAttribute("seekers",seekerService.getSeekerList());
			return "seeker/list";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	@PostMapping(value="/seeker.html/update", params="seekerId")
	public String update(HttpServletRequest  request,@RequestParam("seekerId") String seekerId, Model model) {
		int id = Integer.parseInt(seekerId);
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		int age = Integer.parseInt(request.getParameter("age"));
		String gender = request.getParameter("gender");
		String bloodGroup = request.getParameter("bloodGroup");
		String city = request.getParameter("city");
		Long phone = Long.parseLong(request.getParameter("phone"));
		
		Seeker temp = new Seeker(id, firstName, lastName, age, gender, bloodGroup, city, phone);
		try {
			seekerService.updateSeeker(temp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
		model.addAttribute("seekers",seekerService.getSeekerList());
		return "seeker/list";
	}

	@PostMapping(value="/seeker/add")
	public String add(HttpServletRequest  request, Model model) {
		int id = Integer.parseInt(request.getParameter("seekerId"));
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		int age = Integer.parseInt(request.getParameter("age"));
		String gender = request.getParameter("gender");
		String bloodGroup = request.getParameter("bloodGroup");
		String city = request.getParameter("city");
		Long phone = Long.parseLong(request.getParameter("phone"));
		
		Seeker temp = new Seeker(id, firstName, lastName, age, gender, bloodGroup, city, phone);
		try {
			seekerService.addSeeker(temp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
		model.addAttribute("seekers",seekerService.getSeekerList());
		return "seeker/list";
	}
	
	
}
