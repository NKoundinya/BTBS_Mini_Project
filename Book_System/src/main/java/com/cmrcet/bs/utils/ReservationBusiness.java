package com.cmrcet.bs.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cmrcet.bs.bean.BusDates;
import com.cmrcet.bs.bean.Reservation;
import com.cmrcet.bs.bean.UserBean;
import com.cmrcet.bs.services.SeatAllocationService;
import com.cmrcet.bs.services.TicketCostService;

@Service
public class ReservationBusiness {

	@Autowired
	SeatAllocationService sAService;

	@Autowired
	TicketCostService ticketService;

	public String generatePNR(Reservation reservation) {

		StringBuilder pnr = new StringBuilder();

		String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
		String NUMBER = "0123456789";

		pnr.append("T");
		pnr.append(reservation.getService().getServiceId());

		for (int i = 0; i < 2; i++) {
			pnr.append(ALPHABET.charAt(new Random().nextInt(ALPHABET.length())));
		}

		for (int i = 0; i < 2; i++) {
			pnr.append(NUMBER.charAt(new Random().nextInt(NUMBER.length())));
		}

		return pnr.toString();

	}

	public List<UserBean> findPassengers(BusDates busService, List<Reservation> list) {

		List<UserBean> listOfBean = new ArrayList<>();

		for (Reservation reserve : list) {

			UserBean userBean = new UserBean();
			userBean.setReservation(reserve);
			userBean.setCost(reserve.getSeats() * ticketService.getCost(userBean));

			listOfBean.add(userBean);
		}

		return listOfBean;
	}

	public UserBean findBuses(BusDates busService, List<Reservation> list) {

		UserBean bean = new UserBean();

		if (list.isEmpty()) {

			Reservation rev = new Reservation();
			rev.setService(busService);
			list.add(rev);
			bean.setReservation(rev);
			bean.setCost(0);
			if (busService != null) {
				bean.getReservation().setSeats(sAService.checkSeats(busService));
			}
			return bean;

		}

		List<UserBean> listOfBean = new ArrayList<>();

		for (Reservation reserve : list) {
			UserBean userBean = new UserBean();
			userBean.setReservation(reserve);
			userBean.setCost(reserve.getSeats() * ticketService.getCost(userBean));

			listOfBean.add(userBean);
		}

		for (UserBean obj : listOfBean) {
			bean.setReservation(obj.getReservation());
			bean.setCost(bean.getCost() + obj.getCost());
		}

		bean.getReservation().setSeats(sAService.checkSeats(busService));
		return bean;

	}

}
