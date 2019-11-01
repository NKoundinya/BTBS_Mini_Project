package com.comakeit.bs.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comakeit.bs.bean.BusDates;
import com.comakeit.bs.bean.Reservation;
import com.comakeit.bs.bean.SeatAllocation;
import com.comakeit.bs.bean.TicketCost;
import com.comakeit.bs.bean.UserBean;
import com.comakeit.bs.exception.BSInternalServerException;
import com.comakeit.bs.repositories.SeatAllocationInterface;
import com.comakeit.bs.utils.SeatAllocationBusiness;

@Service
public class SeatAllocationService implements ISeatAllocation {

	@Autowired
	SeatAllocationInterface crud;

	@Autowired
	SeatAllocationBusiness sABusiness;

	@Autowired
	TicketCostService ticketService;

	public List<String> getSources() {

		List<String> sources = new ArrayList<String>();
		crud.getSources().forEach(e -> sources.add(e));

		return sources;

	}

	public List<String> getDestinations() {

		List<String> destinations = new ArrayList<String>();
		crud.getDestinations().forEach(e -> destinations.add(e));

		return destinations;

	}

	public List<TicketCost> getBusesList(UserBean bean) {

		List<SeatAllocation> list = new ArrayList<SeatAllocation>();
		crud.getSeats(bean.getSource(), bean.getDestination(), bean.getDate()).forEach(e -> list.add(e));

		Set<String> buses = sABusiness.getBusesList(bean, list);

		if (buses == null || buses.isEmpty()) {
			throw new BSInternalServerException("Buses Not Found");
		}

		List<TicketCost> ticketCostList = ticketService.getCost(bean, buses);

		return ticketCostList;

	}

	public Integer checkSeats(UserBean bean) {

		List<SeatAllocation> list = new ArrayList<SeatAllocation>();
		crud.checkSeats(bean.getReservation().getService()).forEach(e -> list.add(e));

		return sABusiness.checkSeats(bean, list);

	}

	public Integer checkSeats(BusDates busService) {

		List<SeatAllocation> list = new ArrayList<SeatAllocation>();
		crud.checkSeats(busService).forEach(e -> list.add(e));

		return sABusiness.checkSeats(busService, list);

	}

	public void addSeats(Reservation reservation) {

		List<SeatAllocation> list = new ArrayList<SeatAllocation>();
		crud.checkSeats(reservation.getService()).forEach(e -> list.add(e));
		sABusiness.addSeats(list, reservation);

	}

	public void subSeats(Reservation reservation) {

		List<SeatAllocation> list = new ArrayList<SeatAllocation>();
		crud.checkSeats(reservation.getService()).forEach(e -> list.add(e));

		sABusiness.subSeats(list, reservation);

	}

	public void setSeats(SeatAllocation seatAllocation) {

		crud.save(seatAllocation);

	}

	public List<BusDates> getBusServices(SeatAllocation seatAllocation) {

		List<BusDates> list = new ArrayList<BusDates>();
		crud.getBusService(seatAllocation.getSource(), seatAllocation.getDestination()).forEach(e -> list.add(e));

		return sABusiness.getServiceLists(list);

	}

}
