package com.cmrcet.bs.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cmrcet.bs.bean.BusDates;
import com.cmrcet.bs.bean.Buses;
import com.cmrcet.bs.bean.Payment;
import com.cmrcet.bs.bean.Reservation;
import com.cmrcet.bs.bean.TicketCost;
import com.cmrcet.bs.bean.UserBean;
import com.cmrcet.bs.restcalls.SeatRestCall;
import com.cmrcet.bs.restcalls.TicketCostRestCall;
import com.cmrcet.bs.restcalls.UserBeanRestCall;

@Controller
public class Book {

	@Autowired
	TicketCostRestCall restTicket;

	@Autowired
	SeatRestCall restSeat;

	@Autowired
	UserBeanRestCall restUser;

	@RequestMapping(value = "done")
	public String done(ModelMap map, UserBean bean, HttpSession session) {

		session.setAttribute("UserBean", bean);

		HttpEntity<UserBean> requestEntity = new HttpEntity<>(bean);

		List<TicketCost> ticketList = null;
		try {
			ticketList = restTicket.getCosts("getBuses", requestEntity);
		} catch (Exception e) {

		}
		map.addAttribute("TicketList", ticketList);

		return "SelectaBus";
	}

	@RequestMapping(value = "selected")
	public String selected(ModelMap map, HttpSession session, String busId) {

		UserBean bean = (UserBean) session.getAttribute("UserBean");

		Buses b = new Buses();
		b.setBusid(busId);

		BusDates busDate = new BusDates();
		busDate.setBus(b);

		Reservation reservation = new Reservation();
		reservation.setService(busDate);
		reservation.setDestination(bean.getDestination());
		reservation.setSource(bean.getSource());

		bean.setReservation(reservation);

		HttpEntity<UserBean> requestEntity = new HttpEntity<>(bean);

		bean = restUser.getUser("select", requestEntity);

		requestEntity = new HttpEntity<>(bean);

		Integer seats = restSeat.getDestinations("checkSeats", requestEntity);

		if (seats > 4) {

			map.addAttribute("lessSeats", seats);

		}

		session.setAttribute("UserBean", bean);

		return "EnterDetails";

	}

	@RequestMapping(value = "/pay")
	public String Payment(ModelMap map, HttpSession session, Reservation reservation) {

		UserBean bean = (UserBean) session.getAttribute("UserBean");

		bean.getReservation().setUsername(reservation.getUsername());
		bean.getReservation().setIdProof(reservation.getIdProof());
		bean.getReservation().setSeats(reservation.getSeats());

		return "Payment";
	}
	
	@RequestMapping(value = "/reserve")
	public String reserve(ModelMap map, HttpSession session, Payment payment) {

		UserBean bean = (UserBean) session.getAttribute("UserBean");

		HttpEntity<UserBean> requestEntity = new HttpEntity<>(bean);

		bean = restUser.getUser("select", requestEntity);

		payment.setAmount(bean.getCost());
		payment.setReservation(bean.getReservation());
		
		session.setAttribute("Reservation", bean.getReservation());
		session.setAttribute("payment", payment);
		
		map.addAttribute("reserved", bean);
		map.addAttribute("BOOK", "BOOK");

		return "Details";

	}

}
