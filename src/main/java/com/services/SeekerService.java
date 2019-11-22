package com.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.models.Seeker;

@Service
public class SeekerService {
	
	Map<Integer, Seeker> seekerList = new HashMap<>();
	
	public void addSeeker(Seeker seeker) throws Exception
	{
		if(seekerList.containsKey(seeker.getSeekerId()))
		{
			throw new Exception("This seeker id already exists...");
		}
		else
		{
			seekerList.put(seeker.getSeekerId(), seeker);
		}
	}
	
	public Iterable<Seeker> getSeekerList()
	{
		return seekerList.values();
	}
	
	public Seeker getSeeker(int seekerId) throws Exception
	{
		if(seekerList.containsKey(seekerId))
		{
			return seekerList.get(seekerId);
		}
		else
		{
			throw new Exception("Seeker Id not found...");
		}
	}
	
	public void replaceSeeker(Seeker seeker) throws Exception
	{
		if(seekerList.containsKey(seeker.getSeekerId()))
		{
			seekerList.put(seeker.getSeekerId(),seeker);
		}
		else
		{
			throw new Exception("Seeker Id not found...");
		}
	}
	
	public void updateSeeker(Seeker seeker) throws Exception
	{
		Seeker temp = seekerList.get(seeker.getSeekerId());
		if(seekerList.containsKey(seeker.getSeekerId()))
		{			
			if(seeker.getFirstName()!=null)
				temp.setFirstName(seeker.getFirstName());
			if(seeker.getLastName()!=null)
				temp.setLastName(seeker.getLastName());
			if(seeker.getAge()!=0)
				temp.setAge(seeker.getAge());
			if(seeker.getGender()!=null)
				temp.setGender(seeker.getGender());
			if(seeker.getBloodGroup()!=null)
				temp.setBloodGroup(seeker.getBloodGroup());
			if(seeker.getCity()!=null)
				temp.setCity(seeker.getCity());
			if(seeker.getPhone()!=0)
				temp.setPhone(seeker.getPhone());
			
			seekerList.put(temp.getSeekerId(),temp);
		}
		else
		{
			throw new Exception("Seeker Id not found...");
		}
	}
	
	public void deleteSeeker(int seekerId) throws Exception
	{
		if(seekerList.containsKey(seekerId))
		{
			seekerList.remove(seekerId);
		}
		else 
		{
			throw new Exception("Seeker Id not found");
		}
	}
	
	public Iterable<Seeker> search(String search)
	{
		Map<Integer, Seeker> dummy = new HashMap<>();
		Iterable<Seeker> temp = seekerList.values();
		for(Seeker seeker: temp)
		{
			if(seeker.toString().toLowerCase().contains(search.toLowerCase()))
			{
				dummy.put(seeker.getSeekerId(), seeker);
			}
		}
		return dummy.values();
	}

}
