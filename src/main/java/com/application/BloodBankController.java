package com.application;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.models.BloodBank;
import com.services.BloodBankService;

@Controller
public class BloodBankController {
	
	private final BloodBankService bloodBankService;
	
	public BloodBankController(BloodBankService bloodBankService)
	{
		this.bloodBankService = bloodBankService;
	}
	
	@GetMapping("/bloodBank.html")
	public String getBloodBankList(Model model) {
		model.addAttribute("bloodBanks",bloodBankService.getBloodBankList());
		return "bloodBank/list";
	}
	
	@RequestMapping("/bloodBank/create.html")
	public String create(Model model) {
		return "bloodBank/create";
	}
	
	@PostMapping("/bloodBank/search.html")
	public String search(Model model, HttpServletRequest  request) {
		String search = request.getParameter("search");
		model.addAttribute("bloodBanks",bloodBankService.search(search));
		return "bloodBank/list";
	}
	
	@GetMapping(value="/bloodBank.html", params="bloodBankId")
	public String getBloodBank(@RequestParam("bloodBankId") String bloodBankId, Model model) {
		try {
			BloodBank bloodBank = bloodBankService.getBloodBank(Integer.parseInt(bloodBankId));
			model.addAttribute("bloodBank", bloodBank);
			return "bloodBank/details";
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
	
	@PostMapping(value="/bloodBank.html/delete", params="bloodBankId")
	public String deleteBloodBank(@RequestParam("bloodBankId") String bloodBankId, Model model) {
		try {
			bloodBankService.deleteBloodBank(Integer.parseInt(bloodBankId));
			model.addAttribute("bloodBanks",bloodBankService.getBloodBankList());
			return "bloodBank/list";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	@PostMapping(value="/bloodBank.html/update", params="bloodBankId")
	public String update(HttpServletRequest  request,@RequestParam("bloodBankId") String bloodBankId, Model model) {
		int id = Integer.parseInt(bloodBankId);
		String bloodBankName = request.getParameter("bloodBankName");
		String address = request.getParameter("address");
		String city = request.getParameter("city");
		Long phone = Long.parseLong(request.getParameter("phone"));
		String website = request.getParameter("website");
		String email = request.getParameter("email");
		
		BloodBank temp = new BloodBank(id, bloodBankName, address, city,phone, website, email);
		try {
			bloodBankService.updateBloodBank(temp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
		model.addAttribute("bloodBanks",bloodBankService.getBloodBankList());
		return "bloodBank/list";
	}

	@PostMapping(value="/bloodBank/add")
	public String add(HttpServletRequest  request, Model model) {
		int bloodBankId = Integer.parseInt(request.getParameter("bloodBankId"));
		String bloodBankName = request.getParameter("bloodBankName");
		String address = request.getParameter("address");
		String city = request.getParameter("city");
		Long phone = Long.parseLong(request.getParameter("phone"));
		String website = request.getParameter("website");
		String email = request.getParameter("email");
		
		BloodBank temp = new BloodBank(bloodBankId, bloodBankName, address, city,phone, website, email);
		try {
			bloodBankService.addBloodBank(temp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
		model.addAttribute("bloodBanks",bloodBankService.getBloodBankList());
		return "bloodBank/list";
	}
	
}
