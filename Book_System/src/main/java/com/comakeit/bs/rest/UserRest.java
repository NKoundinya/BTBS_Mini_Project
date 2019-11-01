package com.comakeit.bs.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.comakeit.bs.bean.BusDates;
import com.comakeit.bs.bean.Buses;
import com.comakeit.bs.bean.Reservation;
import com.comakeit.bs.bean.TicketCost;
import com.comakeit.bs.bean.UserBean;
import com.comakeit.bs.exception.BSInternalServerException;
import com.comakeit.bs.services.BusDatesService;
import com.comakeit.bs.services.BusesService;
import com.comakeit.bs.services.ReservationService;
import com.comakeit.bs.services.SeatAllocationService;
import com.comakeit.bs.services.TicketCostService;
import com.comakeit.bs.utils.ReservationBusiness;

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

	/*
	 * Get list of sources available.
	 */
	@GetMapping(value = "/sources")
	public List<String> getSources() {

		List<String> list = sAService.getSources();

		return list;

	}

	/*
	 * Get list of destinations available.
	 */
	@GetMapping(value = "/destinations")
	public List<String> getDestinations() {

		List<String> list = sAService.getDestinations();

		return list;

	}

	/*
	 * Get details of reservation.
	 */
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

	/*
	 * Get details of buses.
	 */
	@PostMapping(value = "/getBuses")
	public List<TicketCost> getBuses(@RequestBody UserBean bean) {

		List<TicketCost> list = sAService.getBusesList(bean);

		return list;

	}

	/*
	 * After selecting a bus.
	 */
	@PostMapping(value = "/select")
	public UserBean selected(@RequestBody UserBean bean) {

		Buses bus = busService.getBus(bean.getReservation().getService().getBus().getBusid());

		BusDates busSer = busDateService.getService(bus, bean.getDate());

		bean.getReservation().setService(busSer);
		bean.getReservation().setPnr(reservationClass.generatePNR(bean.getReservation()));
		bean.setCost(bean.getReservation().getSeats() * tCService.getCost(bean));

		return bean;

	}

	/*
	 * Check available seats.
	 */
	@PostMapping(value = "/checkSeats")
	public Integer checkSeats(@RequestBody UserBean bean) {

		Integer seats = sAService.checkSeats(bean);
		return seats;

	}

	/*
	 * Add reservation.
	 */
	@PostMapping(value = "/book")
	public Reservation book(@RequestBody Reservation reserve) {

		reservationService.add(reserve);

		return reserve;

	}

	/*
	 * Subtract seats.
	 */
	@PutMapping("/setSeats")
	public void set(@RequestBody Reservation reserve) {
		sAService.subSeats(reserve);
	}

	/*
	 * Cancel a ticket.
	 * 
	 * Add seats.
	 */
	@DeleteMapping(value = "/cancel/{pnr}")
	public void cancel(@PathVariable String pnr) {

		Reservation reserve = reservationService.getDetails(pnr);
		reservationService.remove(reserve);
		sAService.addSeats(reserve);

	}

}
