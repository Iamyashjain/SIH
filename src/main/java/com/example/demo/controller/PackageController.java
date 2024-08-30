package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Package;
import com.example.demo.service.PackageService;
import com.example.demo.service.PackageServiceImpl;

@RestController
@CrossOrigin
@RequestMapping("/package")
public class PackageController {
	PackageServiceImpl pser;

	public PackageController(PackageServiceImpl pser) {
		super();
		this.pser = pser;
	}
	@GetMapping("/pack/{id}")
	public Package viewDetailedPackage(@PathVariable int pid) {
		return pser.viewDetailedPackage(pid);
	}
	
	   @GetMapping("/{mid}/packages")
	    public List<Package> getPackagesByMuseumId(@PathVariable("mid") int mid) {
	        return pser.getPackagesByMuseumId(mid);
	    }
    
    @PostMapping("/create")
    public int createPackage(@RequestBody Package p) {
    	return pser.createPackage(p);
    }
}
