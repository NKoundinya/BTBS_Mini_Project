package com.comakeit.bs.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comakeit.bs.bean.BusDates;
import com.comakeit.bs.bean.Buses;
import com.comakeit.bs.repositories.BusDatesInterface;

@Service
public class BusDatesService {


	@Autowired
	BusDatesInterface crud;
	
	public List<BusDates> getBuses(String date) {

		List<BusDates> list = new ArrayList<BusDates>();
		crud.findBuses(date).forEach(e -> list.add(e));
		
		return list;
		
	}

	public BusDates getService(Buses bus, String date) {
		
		return crud.getService(bus, date);
		
	}

}
