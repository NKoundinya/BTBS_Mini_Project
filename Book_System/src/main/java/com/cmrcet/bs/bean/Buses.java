package com.cmrcet.bs.bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "bus")
@Table(name = "bus")
public class Buses {
	
	@Id
	private String busid;
	private String type;
	
	public Buses() {
	}
	
	public Buses(String busid, String type) {
		this.busid = busid;
		this.type = type;
	}

	public String getBusid() {
		return busid;
	}

	public void setBusid(String busid) {
		this.busid = busid;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Buses [busid=" + busid + ", type=" + type + "]";
	}
	
	
}
