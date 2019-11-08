package com.cmrcet.bs.services;

import java.util.List;

import com.cmrcet.bs.bean.Buses;

interface IBus {
	
	Buses getBus(String busId);

	List<Buses> getBuses();
	
}
