package com.comakeit.bs.bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity(name = "ticketcost")
@Table(name = "ticketcost")
public class TicketCost {

	@Id
	private String costId;
	private String source;
	private String destination;
	private int cost;

	@OneToOne
	@JoinColumn(name = "busId")
	private Buses busId;

	public TicketCost() {
	}

	public TicketCost(String costId, String source, String destination, int cost, Buses busId) {
		super();
		this.costId = costId;
		this.source = source;
		this.destination = destination;
		this.cost = cost;
		this.busId = busId;
	}

	public String getCostId() {
		return costId;
	}

	public void setCostId(String costId) {
		this.costId = costId;
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

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public Buses getBusId() {
		return busId;
	}

	public void setBusId(Buses busId) {
		this.busId = busId;
	}

	@Override
	public String toString() {
		return "TicketCost [costId=" + costId + ", source=" + source + ", destination=" + destination + ", cost=" + cost
				+ "bus= " + busId.toString() + "]";
	}
	
	
	
}
