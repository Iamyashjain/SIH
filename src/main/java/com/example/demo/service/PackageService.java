package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Package;

public interface PackageService {
	//get packages of meuseum
	Package viewDetailedPackage(int pid);
	List<Package> getPackagesByMuseumId(int mid);
	int createPackage(Package p);
	
}
