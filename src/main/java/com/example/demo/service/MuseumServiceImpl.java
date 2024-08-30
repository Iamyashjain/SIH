package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Museum;
import com.example.demo.repository.MuseumRepository;

@Service
public class MuseumServiceImpl implements MuseumService {
	
	MuseumRepository mrepo;

	public MuseumServiceImpl(MuseumRepository mrepo) {
		super();
		this.mrepo = mrepo;
	}

	@Override
	public List<Museum> card_details() {
		return mrepo.findAll();
	}

	@Override
	public Museum fullDetails(int mid) {
		// TODO Auto-generated method stub
		mrepo.findById(mid).get();
		Museum m = mrepo.findById(mid).get();
		return m;
	}

	@Override
	public String createmueByAdmin(Museum mue) {
		mrepo.save(mue);
		return "success";
	}

	@Override
	public String updatemueByAdmin(Museum mue) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deletemueByAdmin(Museum mue) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Museum> findMueByState(String state) {
		return mrepo.findMueByState(state);
	}

	@Override
	public List<Museum> findMueBycity(String city) {
		return mrepo.findMueByCity(city);
	}

	@Override
	public List<Museum> findMueByStateandCity(String state, String city) {
		return mrepo.findMueByStateAndCity(state, city);

	}

	@Override
	public List<Museum> searchMuseumsByName(String name) {
		return mrepo.findMuseumsByMunameStartingWith(name);
	}

}
