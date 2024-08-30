package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Booking;
import com.example.demo.model.User;
import com.example.demo.service.BookingService;

@RestController
@CrossOrigin
@RequestMapping("/booking")
public class BookingController {
	@Autowired
	UserController usercont;
	@Autowired
	MuseumController museumcont;
	@Autowired
	PaymentController paymentcont;


	BookingService bser;

	public BookingController(BookingService bser) {
		super();
		this.bser = bser;
	}
	
	@PostMapping("/create")
	public String createBooking(@RequestBody Booking b) {

		b.setUser(usercont.getCurrentUser());
		b.setMid(museumcont.mueid);
		b.setBooking_status("Booking");
		b.setPayment_status("Initiated");
		bser.createBooking(b);


		return paymentcont.createorderdirectly(b,usercont.getCurrentUser());
	}
	
	@GetMapping("/user/{uid}")
	public List<Booking>getbyid(@PathVariable int uid){
		return bser.getbyid(uid);
	}
    @GetMapping("/all")
    public List<Booking> getAll() {
        return bser.getall();
    }
    
    @PostMapping("/status")
    public String changeBookingStatus(@RequestParam int bid, @RequestParam String newStatus) {
        return bser.changeStatusBooking(bid, newStatus);
    }
	
}

