package com.cmrcet.bs.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity(name = "payment")
@Table(name = "payment")
public class Payment {

	@Id
	@GeneratedValue
	private int id;

	@Column(name = "holder")
	private String holder;

	@Column(name = "cardNumber")
	private String cardNumber;

	@Column(name = "amount")
	private int amount;

	@OneToOne
	@JoinColumn(name = "pnrid")
	private Reservation reservation;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getHolder() {
		return holder;
	}

	public void setHolder(String holder) {
		this.holder = holder;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Reservation getReservation() {
		return reservation;
	}

	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}

	@Override
	public String toString() {
		return "Payment [id=" + id + ", holder=" + holder + ", cardNumber=" + cardNumber + ", amount=" + amount
				+ ", reservation=" + reservation + "]";
	}

}
