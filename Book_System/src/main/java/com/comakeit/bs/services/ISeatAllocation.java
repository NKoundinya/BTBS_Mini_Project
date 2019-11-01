package com.comakeit.bs.services;

import java.util.List;

import com.comakeit.bs.bean.BusDates;
import com.comakeit.bs.bean.Reservation;
import com.comakeit.bs.bean.SeatAllocation;
import com.comakeit.bs.bean.TicketCost;
import com.comakeit.bs.bean.UserBean;

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
