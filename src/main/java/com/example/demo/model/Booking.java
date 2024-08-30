package com.example.demo.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;

@Entity
public class Booking {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bid;
    @ManyToOne
    @JoinColumn(name = "uid") // This should match the property name in User
    private User user;
	private int mid;

	public int getMid() {
		return mid;
	}

	public void setMid(int mid) {
		this.mid = mid;
	}

	private String booking_date;
    private String booking_time;
    private String visit_date;
    private String visit_time;
    private String payment_status;
    private String payment_amount;
    private String total_people;
    private String booking_status;
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}

	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Booking(User user) {
		super();
		this.user = user;
	}
	public String getBooking_date() {
		return booking_date;
	}
	public void setBooking_date(String booking_date) {
		this.booking_date = booking_date;
	}
	public String getBooking_time() {
		return booking_time;
	}
	public void setBooking_time(String booking_time) {
		this.booking_time = booking_time;
	}
	public String getVisit_date() {
		return visit_date;
	}
	public void setVisit_date(String visit_date) {
		this.visit_date = visit_date;
	}
	public String getVisit_time() {
		return visit_time;
	}
	public void setVisit_time(String visit_time) {
		this.visit_time = visit_time;
	}
	public String getPayment_status() {
		return payment_status;
	}
	public void setPayment_status(String payment_status) {
		this.payment_status = payment_status;
	}
	public String getPayment_amount() {
		return payment_amount;
	}
	public void setPayment_amount(String payment_amount) {
		this.payment_amount = payment_amount;
	}
	public String getTotal_people() {
		return total_people;
	}
	public void setTotal_people(String total_people) {
		this.total_people = total_people;
	}
	public String getBooking_status() {
		return booking_status;
	}
	public void setBooking_status(String booking_status) {
		this.booking_status = booking_status;
	}
	public Booking(int bid, Set<User> user, String booking_date, String booking_time, String visit_date,
			String visit_time, String payment_status, String payment_amount, String total_people,
			String booking_status) {
		super();
		this.bid = bid;
		this.booking_date = booking_date;
		this.booking_time = booking_time;
		this.visit_date = visit_date;
		this.visit_time = visit_time;
		this.payment_status = payment_status;
		this.payment_amount = payment_amount;
		this.total_people = total_people;
		this.booking_status = booking_status;
	}
	public Booking() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Booking [bid=" + bid + ", user=" + user + ", booking_date=" + booking_date + ", booking_time="
				+ booking_time + ", visit_date=" + visit_date + ", visit_time=" + visit_time + ", payment_status="
				+ payment_status + ", payment_amount=" + payment_amount + ", total_people=" + total_people
				+ ", booking_status=" + booking_status + "]";
	}
	
	//package id
	//meuseum id
	
	
	
}
