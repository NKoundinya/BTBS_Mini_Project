package com.comakeit.bs.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comakeit.bs.bean.TicketCost;
import com.comakeit.bs.bean.UserBean;
import com.comakeit.bs.repositories.TicketInterface;
import com.comakeit.bs.utils.TicketCostBusiness;

@Service
public class TicketCostService implements ITicketCost {

	@Autowired
	TicketInterface crud;

	@Autowired
	TicketCostBusiness ticketClass;
	
	public List<TicketCost> getCost(UserBean bean, Set<String> buses) {

		List<TicketCost> ticketList = new ArrayList<TicketCost>();
		crud.getCost(buses).forEach(e -> ticketList.add(e));
		
		List<TicketCost> busList = ticketClass.getCost(bean, buses, ticketList);
		
		return busList;

	}

	public int getCost(UserBean bean) {

		List<TicketCost> ticketList = new ArrayList<TicketCost>();
		crud.getCost(bean.getReservation().getService().getBus()).forEach(e -> ticketList.add(e));
		
		return ticketClass.getCost(bean, ticketList);

	}

}
