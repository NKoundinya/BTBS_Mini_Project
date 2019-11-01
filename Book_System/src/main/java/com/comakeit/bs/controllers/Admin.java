package com.comakeit.bs.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.comakeit.bs.bean.Buses;
import com.comakeit.bs.bean.Login;
import com.comakeit.bs.restcalls.BusRestCall;
import com.comakeit.bs.restcalls.LoginRestCall;

@Controller
public class Admin {

	@Autowired
	LoginRestCall loginRest;

	@Autowired
	BusRestCall busesRest;

	/*
	 * Validation of Administrator login.
	 */
	@RequestMapping("/Admin")
	public String login(Login login, ModelMap map) {

		try {
			
			login = loginRest.validate("login", login);
			
			map.addAttribute("username", login.getUsername());
			return "Admin";

		} catch (Exception unauthorized) {

			map.addAttribute("WrongLogin", "Wrong Credentials");
			return "Login";

		}
	}

	/*
	 * To get passenger details on a specified bus. Passing the list of buses
	 * available.
	 */
	@RequestMapping("/PassengerDetails")
	public String passengerDetails(ModelMap map) {

		List<Buses> busList = busesRest.getBuses("busesList");

		map.addAttribute("busid", busList);

		map.addAttribute("adminOp", "PassengerDetails");

		return "EnterBus";

	}

	/*
	 * To get income of a specified bus. Passing the list of buses available.
	 */
	@RequestMapping("/CheckIncome")
	public String checkIncome(ModelMap map) {

		List<Buses> busList = busesRest.getBuses("busesList");

		map.addAttribute("busid", busList);

		map.addAttribute("adminOp", "CheckIncome");

		return "EnterBus";

	}

	/*
	 * Logout
	 */
	@RequestMapping("/Logout")
	public String logout(ModelMap map) {

		return "Login";

	}
}
