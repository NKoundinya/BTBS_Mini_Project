package com.cmrcet.bs.services;

import java.util.List;

import com.cmrcet.bs.bean.BusDates;
import com.cmrcet.bs.bean.Buses;

public interface IBusDates {
	
	List<BusDates> getBuses(String date);
	
	BusDates getService(Buses bus, String date);
	
}
