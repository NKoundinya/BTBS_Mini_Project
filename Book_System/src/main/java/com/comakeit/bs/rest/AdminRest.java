package com.comakeit.bs.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.comakeit.bs.bean.BusDates;
import com.comakeit.bs.bean.Buses;
import com.comakeit.bs.bean.Login;
import com.comakeit.bs.bean.SeatAllocation;
import com.comakeit.bs.bean.UserBean;
import com.comakeit.bs.exception.BSUnauthorizedException;
import com.comakeit.bs.services.BusDatesService;
import com.comakeit.bs.services.BusesService;
import com.comakeit.bs.services.LoginService;
import com.comakeit.bs.services.ReservationService;
import com.comakeit.bs.services.SeatAllocationService;
import com.comakeit.bs.utils.ReservationBusiness;
import com.comakeit.bs.utils.SeatAllocationBusiness;

@RestController
public class AdminRest {

	@Autowired
	LoginService loginService;

	@Autowired
	BusesService busService;

	@Autowired
	SeatAllocationBusiness sABusiness;

	@Autowired
	SeatAllocationService sAService;
	
	@Autowired
	ReservationBusiness rBusiness;

	@Autowired
	ReservationService rService;
	
	@Autowired
	BusDatesService busDateService;

	/*
	 * Login validation.
	 */
	@PostMapping(value = "/login")
	public Login loginValidate(@RequestBody Login login) {
		login = loginService.validation(login);
		
		if (login == null) {
			throw new BSUnauthorizedException("Unauthorized User");
		}
		
		return login;
	}

	/*
	 * Gets a list of users on a specified bus and on a specified date.
	 */
	@GetMapping(value = "/buses/{busId}/{date}")
	public List<UserBean> getPassengers(@PathVariable String busId, @PathVariable String date) {

		Buses bus = busService.getBus(busId);

		BusDates busService = busDateService.getService(bus, date);

		List<UserBean> list = rService.findPassengers(busService);

		return list;

	}

	/*
	 * Gets income of a specified bus, on a specified date.
	 */
	@GetMapping(value = "/income/{busId}/{date}")
	public UserBean getIncome(@PathVariable String busId, @PathVariable String date) {

		Buses bus = busService.getBus(busId);

		BusDates busService = busDateService.getService(bus, date);

		if (busService == null) {
			return null;
		}

		UserBean bean = rService.findBuses(busService);

		return bean;
	}

	/*
	 * Gets a list of buses on a specified route.
	 */
	@GetMapping(value = "/listOfBuses/{source}/{destination}")
	public List<BusDates> getBusCount(@PathVariable String source, @PathVariable String destination) {

		List<BusDates> busServices = sAService.getBusServices(new SeatAllocation(source, destination));

		return busServices;

	}

	/*
	 * Shows the available buses list.
	 */
	@GetMapping(value = "busesList")
	public List<Buses> getLists() {

		List<Buses> list = busService.getBuses();

		return list;

	}
}