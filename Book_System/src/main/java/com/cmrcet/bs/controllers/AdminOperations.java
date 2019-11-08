package com.cmrcet.bs.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cmrcet.bs.bean.BusDates;
import com.cmrcet.bs.bean.UserBean;
import com.cmrcet.bs.restcalls.BusDatesRestCall;
import com.cmrcet.bs.restcalls.SeatRestCall;
import com.cmrcet.bs.restcalls.UserBeanRestCall;

@Controller
public class AdminOperations {
	
	@Autowired
	SeatRestCall restSeat;
	
	@Autowired
	UserBeanRestCall restUser;
	
	@Autowired
	BusDatesRestCall restBusDates;
	
	/*
	 * Gets available sources and destinations.
	 */
	@RequestMapping("/BusesBetween")
	public String busesBetween(ModelMap map) {
		
		List<String> source = restSeat.getSources("sources");

		map.addAttribute("Source", source);

		List<String> destination = restSeat.getSources("destinations");

		map.addAttribute("Destination", destination);

		map.addAttribute("adminOp", "BusesBetween");
		
		return "EnterBus";
		
	}
	
	/*
	 * Redirecting to AdminRest to get a List of passengers on the bus given and date specified.
	 */
	@RequestMapping("/BusDetails")
	public String busDetails(String busId, String dateOfTravel, ModelMap map) {

		List<UserBean> beanList = restUser.getUsers("buses/" + busId + "/" + dateOfTravel);

		map.addAttribute("passengers", beanList);
		
		return "ShowDetails";
		
	}
	
	/*
	 * To get a income of bus on a specified date.
	 */
	@RequestMapping("/GetIncome")
	public String getIncome(String busId, String dateOfTravel, ModelMap map) {

		UserBean bean = restUser.getUser("income/" + busId + "/" + dateOfTravel);
		
		map.addAttribute("income", bean);
		
		return "ShowDetails";
	}
	
	/*
	 * To get a bus list with the specified source and destination.
	 */
	@RequestMapping("/BusCount")
	public String busCount(String Source, String Destination, ModelMap map) {
		
		List<BusDates> busDates = restBusDates.getServices("listOfBuses/" + Source + "/" + Destination);
		
		if(Source.equals(Destination)) {
			
			map.addAttribute("count", null);
			
			return "ShowDetails";
			
		}
		
		map.addAttribute("count", busDates);
		
		return "ShowDetails";
	}
}
