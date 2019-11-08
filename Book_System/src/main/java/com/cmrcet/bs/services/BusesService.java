package com.cmrcet.bs.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cmrcet.bs.bean.Buses;
import com.cmrcet.bs.repositories.BusesInterface;

@Service
public class BusesService implements IBus {

	@Autowired
	BusesInterface crud;
 
	public Buses getBus(String busId) {
	
		Buses buses = crud.findById(busId).orElse(new Buses());
		
		return buses;
		
	}

	public List<Buses> getBuses() {
		
		List<Buses> list = new ArrayList<Buses>();
		crud.findAll().forEach(e -> list.add(e));
		
		return list;
		
	}
	
}
