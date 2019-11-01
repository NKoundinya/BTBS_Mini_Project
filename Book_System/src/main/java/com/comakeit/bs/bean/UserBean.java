package com.comakeit.bs.bean;

public class UserBean {

	private Reservation reservation;
	private String date;
	private int cost;
	private String source;
	private String destination;

	public UserBean() {
	}

	public UserBean(Reservation reservation, String date, int cost) {
		super();
		this.reservation = reservation;
		this.date = date;
		this.cost = cost;
	}

	public Reservation getReservation() {
		return reservation;
	}

	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
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

	@Override
	public String toString() {
		return "UserBean [reservation=" + reservation + ", date=" + date + ", cost=" + cost + ", source=" + source
				+ ", destination=" + destination + "]";
	}

}
