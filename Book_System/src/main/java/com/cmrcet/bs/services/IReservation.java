package com.cmrcet.bs.services;

import java.util.List;

import com.cmrcet.bs.bean.BusDates;
import com.cmrcet.bs.bean.Reservation;
import com.cmrcet.bs.bean.UserBean;

public interface IReservation {
	
	Reservation getDetails(String pnr);

	void add(Reservation reserve);

	void remove(Reservation reserve);

	List<UserBean> findPassengers(BusDates busService);
	
	UserBean findBuses(BusDates busDates);

}
