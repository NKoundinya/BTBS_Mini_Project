package com.cmrcet.bs.bean;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity(name = "busservice")
@Table(name = "busservice")
public class BusDates {

	@Id
	@Column(name = "serviceid")
	private String serviceId;

	@OneToOne
	@JoinColumn(name = "busid")
	private Buses bus;
	
	@Column(name = "date")
	private String date;
	
	public BusDates() {
	}

	public BusDates(String serviceId, String date, Buses busId) {
		super();
		this.serviceId = serviceId;
		this.date = date;
		this.setBus(busId);
	}

	public String getServiceId() {
		return serviceId;
	}

	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Buses getBus() {
		return bus;
	}

	public void setBus(Buses bus) {
		this.bus = bus;
	}

	@Override
	public String toString() {
		return "BusService [serviceId=" + serviceId + ", bus=" + bus.toString() + ", date=" + date + "]";
	}

}
