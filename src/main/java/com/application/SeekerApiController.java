package com.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import com.models.Seeker;
import com.services.SeekerService;

@RestController
public class SeekerApiController{
	
	@Autowired
	SeekerService seekerService;

	@RequestMapping(value = "/seeker/{seekerId}", method = RequestMethod.GET)
	Seeker getSeeker(@PathVariable("seekerId") int seekerId) throws Exception
	{
		return seekerService.getSeeker(seekerId);
	}
	
	@RequestMapping(value = "/seekerList", method = RequestMethod.GET)
	Iterable<Seeker> getSeekerList()
	{
		return seekerService.getSeekerList();
	}
	
	@RequestMapping(value = "/seeker", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	String addSeeker(@RequestBody Seeker seeker) throws Exception
	{
		seekerService.addSeeker(seeker);
		return "Seeker added Successfully...";
	}
	
	@RequestMapping(value = "/seeker/{seekerId}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	String replaceSeeker(@PathVariable("seekerId") int seekerId, @RequestBody Seeker seeker) throws Exception
	{
		seeker.setSeekerId(seekerId);
		seekerService.replaceSeeker(seeker);
		return "Seeker replaced Successfully...";
	}
	
	@RequestMapping(value = "/seeker/{seekerId}", method = RequestMethod.PATCH, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	String updateSeeker(@PathVariable("seekerId") int seekerId, @RequestBody Seeker seeker) throws Exception
	{
		seeker.setSeekerId(seekerId);
		seekerService.updateSeeker(seeker);
		return "Seeker updated Successfully...";
	}
	
	@RequestMapping(value = "/seeker/{seekerId}", method = RequestMethod.DELETE)
	@ResponseStatus(value = HttpStatus.OK)
	String deleteSeeker(@PathVariable("seekerId") int seekerId) throws Exception
	{
		seekerService.deleteSeeker(seekerId);
		return "Seeker deleted Successfully...";
	}
}
