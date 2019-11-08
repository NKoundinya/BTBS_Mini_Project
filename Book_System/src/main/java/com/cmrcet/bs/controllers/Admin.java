package com.cmrcet.bs.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cmrcet.bs.bean.Buses;
import com.cmrcet.bs.bean.Login;
import com.cmrcet.bs.restcalls.BusRestCall;
import com.cmrcet.bs.restcalls.LoginRestCall;

@Controller
public class Admin {

	@Autowired
	LoginRestCall loginRest;

	@Autowired
	BusRestCall busesRest;

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

	@RequestMapping("/PassengerDetails")
	public String passengerDetails(ModelMap map) {

		List<Buses> busList = busesRest.getBuses("busesList");

		map.addAttribute("busid", busList);

		map.addAttribute("adminOp", "PassengerDetails");

		return "EnterBus";

	}

	@RequestMapping("/CheckIncome")
	public String checkIncome(ModelMap map) {

		List<Buses> busList = busesRest.getBuses("busesList");

		map.addAttribute("busid", busList);

		map.addAttribute("adminOp", "CheckIncome");

		return "EnterBus";

	}

	@RequestMapping("/Logout")
	public String logout(ModelMap map) {

		return "Login";

	}
}
