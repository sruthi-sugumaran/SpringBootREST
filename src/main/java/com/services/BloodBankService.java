package com.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.models.BloodBank;

@Service
public class BloodBankService {
	
	Map<Integer, BloodBank> bloodBankList = new HashMap<>();
	
	public void addBloodBank(BloodBank bloodBank) throws Exception
	{
		if(bloodBankList.containsKey(bloodBank.getBloodBankId()))
		{
			throw new Exception("This bloodBank id already exists...");
		}
		else
		{
			bloodBankList.put(bloodBank.getBloodBankId(), bloodBank);
		}
	}
	
	public Iterable<BloodBank> getBloodBankList()
	{
		return bloodBankList.values();
	}
	
	public Iterable<BloodBank> search(String search)
	{
		Map<Integer, BloodBank> dummy = new HashMap<>();
		Iterable<BloodBank> temp = bloodBankList.values();
		for(BloodBank bank: temp)
		{
			if(bank.toString().toLowerCase().contains(search.toLowerCase()))
				dummy.put(bank.getBloodBankId(), bank);
		}
		return dummy.values();
	}
	
	public BloodBank getBloodBank(int bloodBankId) throws Exception
	{
		if(bloodBankList.containsKey(bloodBankId))
		{
			return bloodBankList.get(bloodBankId);
		}
		else
		{
			throw new Exception("BloodBank Id not found...");
		}
	}
	
	public void replaceBloodBank(BloodBank bloodBank) throws Exception
	{
		if(bloodBankList.containsKey(bloodBank.getBloodBankId()))
		{
			bloodBankList.put(bloodBank.getBloodBankId(),bloodBank);
		}
		else
		{
			throw new Exception("BloodBank Id not found...");
		}
	}
	
	public void updateBloodBank(BloodBank bloodBank) throws Exception
	{
		BloodBank temp = bloodBankList.get(bloodBank.getBloodBankId());
		
		if(bloodBankList.containsKey(bloodBank.getBloodBankId()))
		{			
			if(bloodBank.getBloodBankName()!=null)
				temp.setBloodBankName(bloodBank.getBloodBankName());
			if(bloodBank.getAddress()!=null)
				temp.setAddress(bloodBank.getAddress());
			if(bloodBank.getCity()!=null)
				temp.setCity(bloodBank.getCity());
			if(bloodBank.getPhone()!=0)
				temp.setPhone(bloodBank.getPhone());
			if(bloodBank.getWebsite()!=null)
				temp.setWebsite(bloodBank.getWebsite());
			if(bloodBank.getEmail()!=null)
				temp.setEmail(bloodBank.getEmail());
			
			bloodBankList.put(temp.getBloodBankId(),temp);
		}
		else
		{
			throw new Exception("BloodBank Id not found...");
		}
	}
	public void deleteBloodBank(int bloodBankId) throws Exception
	{
		if(bloodBankList.containsKey(bloodBankId))
		{
			bloodBankList.remove(bloodBankId);
		}
		else 
		{
			throw new Exception("BloodBank Id not found");
		}
	}

}
