package com.comakeit.bs.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comakeit.bs.bean.BusDates;
import com.comakeit.bs.bean.Reservation;
import com.comakeit.bs.bean.UserBean;
import com.comakeit.bs.services.SeatAllocationService;
import com.comakeit.bs.services.TicketCostService;

@Service
public class ReservationBusiness {

	@Autowired
	SeatAllocationService sAService;

	@Autowired
	TicketCostService ticketService;

	/*
	 * Auto Generate PNR number.
	 */
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


	/*
	 * Find a list of passengers who booked a ticket on specified date.
	 */
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

	/*
	 * To get buServices on a specified date.
	 */
	public UserBean findBuses(BusDates busService, List<Reservation> list) {

		UserBean bean = new UserBean();

		/*
		 * Null check for no service on a date specified.
		 */
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
