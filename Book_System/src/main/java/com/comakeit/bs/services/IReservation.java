package com.comakeit.bs.services;

import java.util.List;

import com.comakeit.bs.bean.BusDates;
import com.comakeit.bs.bean.Reservation;
import com.comakeit.bs.bean.UserBean;

public interface IReservation {
	
	Reservation getDetails(String pnr);

	void add(Reservation reserve);

	void remove(Reservation reserve);

	List<UserBean> findPassengers(BusDates busService);
	
	UserBean findBuses(BusDates busDates);

}
