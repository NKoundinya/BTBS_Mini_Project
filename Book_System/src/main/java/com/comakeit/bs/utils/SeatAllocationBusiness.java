package com.comakeit.bs.utils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comakeit.bs.bean.BusDates;
import com.comakeit.bs.bean.Reservation;
import com.comakeit.bs.bean.SeatAllocation;
import com.comakeit.bs.bean.UserBean;
import com.comakeit.bs.services.BusDatesService;
import com.comakeit.bs.services.SeatAllocationService;

@Service
public class SeatAllocationBusiness {

	@Autowired
	SeatAllocationService seatAllocationDAO;

	@Autowired
	BusDatesService busServiceDAO;

	/*
	 * Get buses on the source and destination specified.
	 */
	public Set<String> getBusesList(UserBean bean, List<SeatAllocation> list) {


		String source = bean.getSource();
		String destination = bean.getDestination();
		
		for (int i = 0; i < list.size(); i++) {
			if (source.equals(list.get(i).getSource())) {
				source = list.get(i).getDestination();
				if (destination.equals(list.get(i).getDestination())) {
					break;
				}
			}
			if (i == list.size() - 1) {
				if (!destination.equals(list.get(i).getDestination())) {
					return null;
				} else {
					break;
				}
			}
		}

		Set<String> buses = new HashSet<>();

		for (SeatAllocation seat : list) {
			buses.add(seat.getBusService().getBus().getBusid());
		}
		
		return buses;
	}

	/*
	 * Get a list of buses available in a week.
	 */
	public List<BusDates> getServiceLists(List<BusDates> busService) {

		List<BusDates> list = new ArrayList<>();
		for (BusDates bus : busService) {
			LocalDate date = LocalDate.parse(bus.getDate());
			if ((date.isEqual(LocalDate.now()) || date.isAfter(LocalDate.now()))
					&& date.isBefore(LocalDate.now().plusDays(7))) {

				list.add(bus);

			}
		}
		
		return list;
	}

	/*
	 * Checking available seats for the source and destination specified by user.
	 */
	public Integer checkSeats(UserBean bean, List<SeatAllocation> seatList) {

		String destination = bean.getDestination();
		String source = bean.getSource();

		int seats = seatList.get(0).getSeats();
		for (SeatAllocation seatLists : seatList) {
			if (!destination.equals(source)) {
				if (seats > seatLists.getSeats()) {
					seats = seatLists.getSeats();
				}

				source = seatLists.getDestination();

			}
		}
		return seats;
	}

	/*
	 * Checking remaining seats in a bus.
	 */
	public Integer checkSeats(BusDates busService, List<SeatAllocation> seatList) {
		
		Reservation reservation = new Reservation();
		reservation.setService(busServiceDAO.getService(busService.getBus(), busService.getDate()));

		int seats = seatList.get(0).getSeats();
		for (SeatAllocation seatLists : seatList) {
			if (seats > seatLists.getSeats()) {

				seats = seatLists.getSeats();

			}
		}

		return seats;
	}

	/*
	 * Adding seats when a ticket is cancelled.
	 */
	public void addSeats(List<SeatAllocation> seatList, Reservation reservation) {

		String destination = reservation.getDestination();
		String source = reservation.getSource();

		for (SeatAllocation seatLists : seatList) {
			if (seatLists.getSource().equals(source)) {
				if (!destination.equals(source)) {

					seatLists.setSeats(seatLists.getSeats() + reservation.getSeats());

					source = seatLists.getDestination();

					seatAllocationDAO.setSeats(seatLists);
				}
			}
		}

	}

	/*
	 * Subtracting seats when a ticket is booked.
	 */
	public void subSeats(List<SeatAllocation> seatList, Reservation reservation) {

		String destination = reservation.getDestination();
		String source = reservation.getSource();

		List<String> seatIDs = new ArrayList<String>();

		for (SeatAllocation seatLists : seatList) {
			if (seatLists.getSource().equals(source)) {
				if (!destination.equals(source)) {

					seatIDs.add(seatLists.getSeatId());
					seatLists.setSeats(seatLists.getSeats() - reservation.getSeats());

					source = seatLists.getDestination();
					
					seatAllocationDAO.setSeats(seatLists);

				}
			}
		}

	}

}
