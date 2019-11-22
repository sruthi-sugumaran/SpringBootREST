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

import com.models.BloodStock;
import com.services.BloodStockService;

@RestController
public class BloodStockApiController {

	@Autowired
	BloodStockService bloodStockService;
	
	@RequestMapping(value = "/bloodStock/{bloodStockId}", method = RequestMethod.GET)
	BloodStock getBloodStock(@PathVariable("bloodStockId") int bloodStockId) throws Exception
	{
		return bloodStockService.getBloodStock(bloodStockId);
	}
	
	@RequestMapping(value = "/bloodStockList", method = RequestMethod.GET)
	Iterable<BloodStock> getBloodStockList()
	{
		return bloodStockService.getBloodStockList();
	}
	
	@RequestMapping(value = "/bloodStock", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	String addBloodStock(@RequestBody BloodStock bloodStock) throws Exception
	{
		bloodStockService.addBloodStock(bloodStock);
		return "Blood Stock added Successfully...";
	}
	
	@RequestMapping(value = "/bloodStock/{bloodStockId}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	String replaceBloodStock(@PathVariable("bloodStockId") int bloodStockId, @RequestBody BloodStock bloodStock) throws Exception
	{
		bloodStock.setBloodStockId(bloodStockId);
		bloodStockService.replaceBloodStock(bloodStock);
		return "Blood Stock replaced Successfully...";
	}
	
	@RequestMapping(value = "/bloodStock/{bloodStockId}", method = RequestMethod.PATCH, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	String updateBloodStock(@PathVariable("bloodStockId") int bloodStockId, @RequestBody BloodStock bloodStock) throws Exception
	{
		bloodStock.setBloodStockId(bloodStockId);
		bloodStockService.updateBloodStock(bloodStock);
		return "Blood Stock updated Successfully...";
	}
	
	@RequestMapping(value = "/bloodStock/{bloodStockId}", method = RequestMethod.DELETE)
	@ResponseStatus(value = HttpStatus.OK)
	String deleteBloodStock(@PathVariable("bloodStockId") int bloodStockId) throws Exception
	{
		bloodStockService.deleteBloodStock(bloodStockId);
		return "Blood Stock deleted Successfully...";
	}
}
