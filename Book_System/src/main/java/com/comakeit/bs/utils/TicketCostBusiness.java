package com.comakeit.bs.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.comakeit.bs.bean.Reservation;
import com.comakeit.bs.bean.TicketCost;
import com.comakeit.bs.bean.UserBean;

@Service
public class TicketCostBusiness {

	/*
	 * Calculate cost of a single ticket for a list of buses.
	 */
	public List<TicketCost> getCost(UserBean bean, Set<String> buses, List<TicketCost> busList) {

		String source = bean.getSource();
		
		int sum = 0;
		
		String destination = bean.getDestination();

		List<TicketCost> list = new ArrayList<>();
		for (String busLists : buses) {
			sum = 0;
			
			source = bean.getSource();
			
			TicketCost ticket = new TicketCost();
			
			for (TicketCost ticketLists : busList) {
				if (ticketLists.getBusId().getBusid().equals(busLists)) {
					if (!destination.equals(source)) {
						
						sum += ticketLists.getCost();
						source = ticketLists.getDestination();
						
					}
					ticket = ticketLists;
				}
			}
			
			ticket.setCost(sum);
			ticket.setSource(bean.getSource());
			ticket.setDestination(bean.getDestination());
			
			list.add(ticket);
		}
		
		
		return list;
		
	}

	/*
	 * Calculate cost of tickets booked by User.
	 */
	public int getCost(UserBean bean, List<TicketCost> list) {
		
		Reservation reservation = bean.getReservation();
		
		int sum = 0;
		String destination = reservation.getDestination();
		String source = reservation.getSource();
		
		for (TicketCost ticket : list) {
			if(source.equals(ticket.getSource())) {
				if (!destination.equals(source)) {
					
					sum += ticket.getCost();
					
					source = ticket.getDestination();
					
				}
			}
		}
		
		return sum;
	}

}
