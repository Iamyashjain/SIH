package com.example.demo.service;

import java.util.Date;
import java.util.List;

import com.example.demo.model.User;

public interface UserService {
	public int insert(User b);
	public List<User> getall();
	public User getbyid(int id);
	public void updateLastLogin(int uid, String date);
	
}
