package com.cmrcet.bs.bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity(name = "reservation")
@Table(name = "reservation")
public class Reservation {

	@Id
	private String pnr;
	private String username;
	private String idProof;
	private int seats;
	private String source;
	private String destination;

	@OneToOne
	@JoinColumn(name = "journey_serviceId")
	private BusDates service;

	public Reservation() {
	}

	public Reservation(String pnr, String username, String idProof) {
		super();
		this.pnr = pnr;
		this.username = username;
		this.idProof = idProof;
	}

	public String getIdProof() {
		return idProof;
	}

	public void setIdProof(String idProof) {
		this.idProof = idProof;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getSeats() {
		return seats;
	}

	public void setSeats(int seats) {
		this.seats = seats;
	}

	public String getPnr() {
		return pnr;
	}

	public void setPnr(String pnr) {
		this.pnr = pnr;
	}

	public BusDates getService() {
		return service;
	}

	public void setService(BusDates service) {
		this.service = service;
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
		return "Reservation [pnr=" + pnr + ", username=" + username + ", idProof=" + idProof + ", seats=" + seats
				+ ", source=" + source + ", destination=" + destination + ", service= " + service.toString() + " ]";
	}

}
