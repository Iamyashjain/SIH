package com.example.demo.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	UserRepository urepo;
	public UserServiceImpl(UserRepository urepo) {
		super();
		this.urepo = urepo;
	}
	@Override
	public int insert(User b) {
		System.out.println("Saving user: " + b);
		User savedUser = urepo.save(b);
		// Return the auto-generated ID
		return savedUser.getUid();
	}


	@Override
	public List<User> getall() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getbyid(int id) {

		return urepo.findById(id).get();
	}
	@Override
	public void updateLastLogin(int uid, String date) {
		// TODO Auto-generated method stub
		User user = urepo.findById(uid).get();
		if(user!=null) {
			user.setLastLogin(date);
			urepo.save(user);
		}
		
		
	}
	

}
