package com.cmrcet.bs.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cmrcet.bs.bean.BusDates;
import com.cmrcet.bs.bean.Buses;
import com.cmrcet.bs.bean.Payment;
import com.cmrcet.bs.bean.Reservation;
import com.cmrcet.bs.bean.TicketCost;
import com.cmrcet.bs.bean.UserBean;
import com.cmrcet.bs.exception.BSInternalServerException;
import com.cmrcet.bs.services.BusDatesService;
import com.cmrcet.bs.services.BusesService;
import com.cmrcet.bs.services.ReservationService;
import com.cmrcet.bs.services.SeatAllocationService;
import com.cmrcet.bs.services.TicketCostService;
import com.cmrcet.bs.utils.ReservationBusiness;

@RestController
public class UserRest {
	
	@Autowired
	SeatAllocationService sAService;

	@Autowired
	BusDatesService busDateService;

	@Autowired
	TicketCostService tCService;

	@Autowired
	BusesService busService;

	@Autowired
	ReservationBusiness reservationClass;

	@Autowired
	ReservationService reservationService;

	@GetMapping(value = "/sources")
	public List<String> getSources() {

		List<String> list = sAService.getSources();

		return list;

	}

	@GetMapping(value = "/destinations")
	public List<String> getDestinations() {

		List<String> list = sAService.getDestinations();

		return list;

	}

	@PostMapping(value = "/getReserved")
	public UserBean getReservation(@RequestBody String pnr) {

		UserBean bean = new UserBean();

		Reservation reserve = reservationService.getDetails(pnr);

		if (reserve == null) {
			throw new BSInternalServerException("No Reservation Found");
		}
		bean.setReservation(reserve);
		bean.setCost(reserve.getSeats() * tCService.getCost(bean));

		return bean;
	}

	@PostMapping(value = "/getBuses")
	public List<TicketCost> getBuses(@RequestBody UserBean bean) {

		List<TicketCost> list = sAService.getBusesList(bean);

		return list;

	}

	@PostMapping(value = "/select")
	public UserBean selected(@RequestBody UserBean bean) {

		Buses bus = busService.getBus(bean.getReservation().getService().getBus().getBusid());
		
		BusDates busSer = busDateService.getService(bus, bean.getDate());

		bean.getReservation().setService(busSer);
		bean.getReservation().setPnr(reservationClass.generatePNR(bean.getReservation()));
		bean.setCost(bean.getReservation().getSeats() * tCService.getCost(bean));

		return bean;

	}

	@PostMapping(value = "/checkSeats")
	public Integer checkSeats(@RequestBody UserBean bean) {

		Integer seats = sAService.checkSeats(bean);
		return seats;

	}

	@PostMapping(value = "/book")
	public Reservation book(@RequestBody Reservation reserve) {

		reservationService.add(reserve);

		return reserve;

	}

	@PutMapping("/setSeats")
	public void set(@RequestBody Reservation reserve) {
		sAService.subSeats(reserve);
	}

	@DeleteMapping(value = "/cancel/{pnr}")
	public void cancel(@PathVariable String pnr) {

		Reservation reserve = reservationService.getDetails(pnr);
		reservationService.remove(reserve);
		sAService.addSeats(reserve);

	}

	@PostMapping("/addPayment")
	public void addPayment(@RequestBody Payment payment) {
		reservationService.addPayment(payment);
	}
	
	@DeleteMapping("/removePayment/{pnr}")
	public void removePayment(@PathVariable String pnr) {
		
		Payment payment = reservationService.getPayment(pnr);
		reservationService.removePay(payment);
		
	}
}
