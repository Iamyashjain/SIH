package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Booking;

public interface BookingService {
	int createBooking(Booking b);
	List<Booking>getbyid(int uid);
	List<Booking>getall();
	String changeStatusBooking(int bid,String ans);
}
