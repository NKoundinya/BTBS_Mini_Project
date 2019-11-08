package com.cmrcet.bs.services;

import java.util.List;

import com.cmrcet.bs.bean.BusDates;
import com.cmrcet.bs.bean.Reservation;
import com.cmrcet.bs.bean.SeatAllocation;
import com.cmrcet.bs.bean.TicketCost;
import com.cmrcet.bs.bean.UserBean;

public interface ISeatAllocation {

	List<String> getSources();

	List<String> getDestinations();

	List<TicketCost> getBusesList(UserBean bean);

	Integer checkSeats(UserBean bean);

	Integer checkSeats(BusDates busService);

	void addSeats(Reservation reservation);
	
	void subSeats(Reservation reservation);

	void setSeats(SeatAllocation seatAllocation);

	List<BusDates> getBusServices(SeatAllocation seatAllocation);
	
}
