package com.comakeit.bs.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.comakeit.bs.bean.Buses;
import com.comakeit.bs.repositories.BusesInterface;

@Repository
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
