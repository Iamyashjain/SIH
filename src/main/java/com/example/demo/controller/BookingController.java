package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	@Autowired
	VisitController visitcont;

String sesssion_id;
	int bid;
	BookingService bser;

	public BookingController(BookingService bser) {
		super();
		this.bser = bser;
	}
	@GetMapping("/get")
	public Map sessionID()
	{
		Map map=new HashMap();
		map.put("sessionId",sesssion_id);
		return map;
	}
	@PostMapping("/create")
	public Map createBooking(@RequestBody Booking b) {

		b.setUser(usercont.getCurrentUser());
		b.setMid(museumcont.mueid);
		b.setBooking_status("Booking");
		b.setPayment_status("Initiated");
		bid=bser.createBooking(b);

		sesssion_id=paymentcont.createorderdirectly(b,usercont.getCurrentUser());
		Map map=new HashMap();
		map.put("sessionId",sesssion_id);
		return map;
	}
	
	@GetMapping("/user/{uid}")
	public List<Booking>getbyid(@PathVariable int uid){
		return bser.getbyid(uid);
	}
	@GetMapping("/booking")
	public Booking getcurrentbooking(){
		return bser.getbyidone(bid);
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

