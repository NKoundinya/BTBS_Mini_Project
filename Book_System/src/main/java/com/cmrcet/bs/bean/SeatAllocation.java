package com.cmrcet.bs.bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name = "seatallocation")
@Table(name = "seatallocation")
public class SeatAllocation {
	
	@Id
	private String seatId;
	private String source;
	private String destination;
	private int seats;
	
	@ManyToOne
	@JoinColumn(name = "serviceid")
	private BusDates busService;
	
	public SeatAllocation() {}

	public SeatAllocation(String seatId, String source, String destination, int seats) {
		super();
		this.seatId = seatId;
		this.source = source;
		this.destination = destination;
		this.seats = seats;
	}

	public SeatAllocation(String source, String destination) {
		this.source = source;
		this.destination = destination;
	}

	public String getSeatId() {
		return seatId;
	}

	public void setSeatId(String seatId) {
		this.seatId = seatId;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public int getSeats() {
		return seats;
	}

	public void setSeats(int seats) {
		this.seats = seats;
	}

	public BusDates getBusService() {
		return busService;
	}

	public void setBusService(BusDates busService) {
		this.busService = busService;
	}

	@Override
	public String toString() {
		return "SeatAllocation [seatId=" + seatId + ", source=" + source + ", destination=" + destination + ", seats="
				+ seats + ", busService=" + busService.toString() + "]";
	}
	
}
