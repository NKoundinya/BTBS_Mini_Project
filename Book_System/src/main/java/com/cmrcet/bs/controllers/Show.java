package com.cmrcet.bs.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cmrcet.bs.bean.Reservation;
import com.cmrcet.bs.bean.UserBean;
import com.cmrcet.bs.restcalls.SeatRestCall;
import com.cmrcet.bs.restcalls.UserBeanRestCall;

@Controller
public class Show {

	@Autowired
	UserBeanRestCall restUser;

	@Autowired
	SeatRestCall restSeat;

	/*
	 * If PNR number is found, redirects to Details.jsp
	 * 
	 * Else to Cancel.jsp
	 */
	@RequestMapping(value = "/Details")
	public String details(String pnr, ModelMap map) {

		try {
			UserBean bean = restUser.getReservation("getReserved", pnr);

			map.addAttribute("reserved", bean);
			return "Details";

		} catch (Exception notFound) {

			map.addAttribute("Enter", "Details");
			map.addAttribute("NotFound", pnr);
			return "Cancel";

		}
	}

	/*
	 * If PNR number is found, redirects to Details.jsp
	 * 
	 * Else to Cancel.jsp
	 */
	@RequestMapping(value = "/DetailsCancel")
	public String cancelling(String pnr, ModelMap map) {


		try {

			UserBean bean = restUser.getReservation("getReserved", pnr);
			
			map.addAttribute("reserved", bean);
			map.addAttribute("SURE", "SURE");
			return "Details";

		} catch (Exception e) {

			map.addAttribute("Enter", "Cancel");
			map.addAttribute("NotFound", pnr);
			return "Cancel";

		}
	}

	/*
	 * After a ticket being booked, the function below adds a record to reservation
	 * table
	 */
	@RequestMapping(value = "/Book")
	public String book(HttpSession session, ModelMap map) {

		Reservation reservation = (Reservation) session.getAttribute("Reservation");
		session.removeAttribute("Reservation");

		reservation = restUser.book("book", reservation);
		restSeat.setSeats("setSeats", reservation);

		return "index";

	}

	/*
	 * Details.jsp to Close
	 */
	@RequestMapping(value = "/index")
	public void close() {
	}

	/*
	 * Redirecting to DAO to cancel a ticket.
	 * 
	 * Deletes a record from reservation table
	 */
	@RequestMapping(value = "/Cancel")
	public String cancel(String pnr) {

		restUser.delete("cancel/" + pnr);
		return "index";

	}

}
