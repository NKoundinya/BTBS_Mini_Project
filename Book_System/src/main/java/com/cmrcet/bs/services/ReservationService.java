package com.cmrcet.bs.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cmrcet.bs.bean.BusDates;
import com.cmrcet.bs.bean.Payment;
import com.cmrcet.bs.bean.Reservation;
import com.cmrcet.bs.bean.UserBean;
import com.cmrcet.bs.repositories.PaymentRepo;
import com.cmrcet.bs.repositories.ReservationInterface;
import com.cmrcet.bs.utils.ReservationBusiness;

@Service
public class ReservationService implements IReservation {

	@Autowired
	ReservationInterface crud;
	
	@Autowired
	PaymentRepo payRepo;
	
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

	public void addPayment(Payment payment) {
		payRepo.saveAndFlush(payment);
	}

	public Payment getPayment(String pnr) {
		
		return payRepo.findPayment(pnr);
	}

	public void removePay(Payment payment) {
		payRepo.delete(payment);
	}
}
