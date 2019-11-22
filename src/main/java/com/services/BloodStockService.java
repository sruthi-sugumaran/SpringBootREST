package com.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.models.BloodStock;

@Service
public class BloodStockService {
	
	Map<Integer, BloodStock> bloodStockList = new HashMap<>();
	
	public void addBloodStock(BloodStock bloodStock) throws Exception
	{
		if(bloodStockList.containsKey(bloodStock.getBloodStockId()))
		{
			throw new Exception("This bloodStock id already exists...");
		}
		else
		{
			bloodStockList.put(bloodStock.getBloodStockId(), bloodStock);
		}
	}
	
	public Iterable<BloodStock> getBloodStockList()
	{
		return bloodStockList.values();
	}
	
	public BloodStock getBloodStock(int bloodStockId) throws Exception
	{
		if(bloodStockList.containsKey(bloodStockId))
		{
			return bloodStockList.get(bloodStockId);
		}
		else
		{
			throw new Exception("BloodStock Id not found...");
		}
	}
	
	public void replaceBloodStock(BloodStock bloodStock) throws Exception
	{
		if(bloodStockList.containsKey(bloodStock.getBloodStockId()))
		{
			bloodStockList.put(bloodStock.getBloodStockId(),bloodStock);
		}
		else
		{
			throw new Exception("BloodStock Id not found...");
		}
	}
	
	public void updateBloodStock(BloodStock bloodStock) throws Exception
	{
		BloodStock temp = bloodStockList.get(bloodStock.getBloodStockId());
		
		if(bloodStockList.containsKey(bloodStock.getBloodStockId()))
		{
			if(bloodStock.getBloodGroup()!=null)
				temp.setBloodGroup(bloodStock.getBloodGroup());
			if(bloodStock.getQuantity()!=0)
				temp.setQuantity(bloodStock.getQuantity());
			if(bloodStock.getExpiryDate()!=null)
				temp.setExpiryDate(bloodStock.getExpiryDate());
			if(bloodStock.getStatus()!=null)
				temp.setStatus(bloodStock.getStatus());
			
			bloodStockList.put(temp.getBloodStockId(),temp);
		}
		else
		{
			throw new Exception("BloodStock Id not found...");
		}
	}
	
	public void deleteBloodStock(int bloodStockId) throws Exception
	{
		if(bloodStockList.containsKey(bloodStockId))
		{
			bloodStockList.remove(bloodStockId);
		}
		else 
		{
			throw new Exception("BloodStock Id not found");
		}
	}

}
