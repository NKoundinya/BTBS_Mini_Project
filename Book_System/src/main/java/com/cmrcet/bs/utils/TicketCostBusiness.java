package com.cmrcet.bs.utils;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.cmrcet.bs.bean.Reservation;
import com.cmrcet.bs.bean.TicketCost;
import com.cmrcet.bs.bean.UserBean;

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
			if (source.equals(ticket.getSource())) {
				if (!destination.equals(source)) {

					sum += ticket.getCost();

					source = ticket.getDestination();

				}
			}
		}

		return generateCost(sum, LocalDate.parse(bean.getReservation().getService().getDate()), LocalDate.now());
	}

	private int generateCost(int cost, LocalDate date, LocalDate today) {

		System.out.println("Months: " + Period.between(today, date).getMonths());
		System.out.println("Days: " + Period.between(today, date).getDays());

		if (Period.between(today, date).getMonths() >= 3) {
			return cost -= (cost * 0.3);
		} else if (Period.between(today, date).getMonths() >= 2) {
			return cost -= (cost * 0.2);
		} else if (Period.between(today, date).getMonths() >= 1) {
			return cost -= (cost * 0.1);
		} else if (Period.between(today, date).getDays() <= 10 && Period.between(today, date).getDays() >= 3) {
			return cost -= (cost * 0.05);
		} else if (Period.between(today, date).getDays() == 0 || Period.between(date, today).getDays() == 2
				|| Period.between(today, date).getDays() == 3) {
			return cost += (cost * 0.1);
		}

		return cost;
	}

}
