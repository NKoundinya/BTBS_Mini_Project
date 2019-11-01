package com.comakeit.bs.services;

import java.util.List;

import com.comakeit.bs.bean.BusDates;
import com.comakeit.bs.bean.Buses;

public interface IBusDates {
	
	List<BusDates> getBuses(String date);
	
	BusDates getService(Buses bus, String date);
	
}
