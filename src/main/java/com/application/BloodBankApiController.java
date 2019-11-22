package com.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.models.BloodBank;
import com.services.BloodBankService;

@RestController
public class BloodBankApiController {
	
	@Autowired
	BloodBankService bloodBankService;
	
	@RequestMapping(value = "/bloodBank/{bloodBankId}", method = RequestMethod.GET)
	BloodBank getBloodBank(@PathVariable("bloodBankId") int bloodBankId) throws Exception
	{
		return bloodBankService.getBloodBank(bloodBankId);
	}
	
	@RequestMapping(value = "/bloodBankList", method = RequestMethod.GET)
	Iterable<BloodBank> getBloodBankList()
	{
		return bloodBankService.getBloodBankList();
	}
	
	@RequestMapping(value = "/bloodBank", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	String addBloodBank(@RequestBody BloodBank bloodBank) throws Exception
	{
		bloodBankService.addBloodBank(bloodBank);
		return "Blood Bank added Successfully...";
	}
	
	@RequestMapping(value = "/bloodBank/{bloodBankId}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	String replaceBloodBank(@PathVariable("bloodBankId") int bloodBankId, @RequestBody BloodBank bloodBank) throws Exception
	{
		bloodBank.setBloodBankId(bloodBankId);
		bloodBankService.replaceBloodBank(bloodBank);
		return "Blood Bank replaced Successfully...";
	}
	
	@RequestMapping(value = "/bloodBank/{bloodBankId}", method = RequestMethod.PATCH, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	String updateBloodBank(@PathVariable("bloodBankId") int bloodBankId, @RequestBody BloodBank bloodBank) throws Exception
	{
		bloodBank.setBloodBankId(bloodBankId);
		bloodBankService.updateBloodBank(bloodBank);
		return "Blood Bank updated Successfully...";
	}
	
	@RequestMapping(value = "/bloodBank/{bloodBankId}", method = RequestMethod.DELETE)
	@ResponseStatus(value = HttpStatus.OK)
	String deleteBloodBank(@PathVariable("bloodBankId") int bloodBankId) throws Exception
	{
		bloodBankService.deleteBloodBank(bloodBankId);
		return "Blood Bank deleted Successfully...";
	}
}

