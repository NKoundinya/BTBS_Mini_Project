package com.comakeit.bs.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comakeit.bs.bean.BusDates;
import com.comakeit.bs.bean.Reservation;
import com.comakeit.bs.bean.UserBean;
import com.comakeit.bs.repositories.ReservationInterface;
import com.comakeit.bs.utils.ReservationBusiness;

@Service
public class ReservationService implements IReservation {

	@Autowired
	ReservationInterface crud;
	
	@Autowired
	ReservationBusiness rBusiness;

	public Reservation getDetails(String pnr) {

		Reservation reservation = crud.findOne(pnr);
		return reservation;

	}

	public void add(Reservation reserve) {
		
		crud.save(reserve);
		
	}

	public void remove(Reservation reserve) {
		
		crud.delete(reserve);
		
	}

	public List<UserBean> findPassengers(BusDates busService) {
		
		List<Reservation> reserve = new ArrayList<Reservation>();
		crud.findAll(busService).forEach(e -> reserve.add(e));
		
		return rBusiness.findPassengers(busService, reserve);

	}

	public UserBean findBuses(BusDates busDates) {
		
		List<Reservation> reserve = new ArrayList<Reservation>();
		crud.findAll(busDates).forEach(e -> reserve.add(e));
		
		return rBusiness.findBuses(busDates, reserve);
	}
	
}
