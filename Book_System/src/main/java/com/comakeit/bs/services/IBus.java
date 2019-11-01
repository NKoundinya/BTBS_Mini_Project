package com.comakeit.bs.services;

import java.util.List;

import com.comakeit.bs.bean.Buses;

interface IBus {
	
	Buses getBus(String busId);

	List<Buses> getBuses();
	
}
