package com.cmrcet.bs.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cmrcet.bs.restcalls.SeatRestCall;

@Controller
public class Control {

	@Autowired
	SeatRestCall restSeat;
	
	/*
	 * Controller of JSP from index to other.
	 */
	@RequestMapping(value = "/controller")
	public String controller(String control, ModelMap map) {

		/*
		 * Passes a list of sources and destinations available and redirects from
		 * index.jsp to SelectRoute.jsp
		 */
		if (control.equals("Book Ticket")) {

			List<String> sources = restSeat.getSources("sources");

			map.addAttribute("Sources", sources);

			List<String> destinations = restSeat.getSources("destinations");

			map.addAttribute("Destination", destinations);

			return "SelectRoute";

		} else if (control.equals("Admin")) {
			
			return "Login";

		} else if (control.equals("Show Ticket Details")) {

			map.addAttribute("Enter", "Details");
			return "Cancel";

		} else if (control.equals("Cancel Ticket")) {

			map.addAttribute("Enter", "Cancel");
			return "Cancel";

		} else {
			return "Admin";
		}

	}
}
