package com.example.demo.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.*;

import com.example.demo.model.User;
import com.example.demo.service.UserServiceImpl;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {
     int uid=1;
    UserServiceImpl userv;
	public UserController(UserServiceImpl userv) {
		super();
		this.userv = userv;
	}
	@GetMapping("/currentuser")
	public User getCurrentUser() {

		return userv.getbyid(uid);
	}

	@PostMapping("/save")
	public int insert(@RequestBody User b1) {
		uid=userv.insert(b1);
		return uid;
	}

	@PostMapping("/saves")
	public Map insertrandom(@RequestBody User b1) {
		uid=userv.insert(b1);
		Map map=new HashMap();
		map.put("sessionId",uid);
		return map;
	}
	
	@PostMapping("/updatelast")
	public void updatelastLogin(int uid, String date) {
		userv.updateLastLogin(uid, date);
	}
	

}
