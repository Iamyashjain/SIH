package com.example.demo.model;

import java.util.Set;

import jakarta.persistence.*;

@Entity
@Table(name="museum")
public class Museum {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int mid;
	private String muname;
	private String description;
	private String city;
	private String state;
	private String mapURL;
    private String openingHours; // Opening Hours
    private String closingHours; // Closing Hours
    private String openingDay; // Opening Day
    private String closingDay; // Closing Day
    private String contactNo; // Contact Number
    private String email; // Email
    private String keyFeatures; // Key Features
    private String availableFacilities;
    private int visitorCapacity;
    private String instaId;
    private String fbId;
    private String websiteId;
    private String ytId;
    
//    @OneToMany
//    @JoinColumn("")
//    private Set<Package> packages;
//	public Museum(Set<Package> packages) {
//		super();
//		this.packages = packages;
//	}
//	public Set<Package> getPackages() {
//		return packages;
//	}
//	public void setPackages(Set<Package> packages) {
//		this.packages = packages;
//	}
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public String getMuname() {
		return muname;
	}
	public void setMuname(String muname) {
		this.muname = muname;
	}

	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getMapURL() {
		return mapURL;
	}
	public void setMapURL(String mapURL) {
		this.mapURL = mapURL;
	}
	public String getOpeningHours() {
		return openingHours;
	}
	public void setOpeningHours(String openingHours) {
		this.openingHours = openingHours;
	}
	public String getClosingHours() {
		return closingHours;
	}
	public void setClosingHours(String closingHours) {
		this.closingHours = closingHours;
	}
	public String getOpeningDay() {
		return openingDay;
	}
	public void setOpeningDay(String openingDay) {
		this.openingDay = openingDay;
	}
	public String getClosingDay() {
		return closingDay;
	}
	public void setClosingDay(String closingDay) {
		this.closingDay = closingDay;
	}
	public String getContactNo() {
		return contactNo;
	}
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getKeyFeatures() {
		return keyFeatures;
	}
	public void setKeyFeatures(String keyFeatures) {
		this.keyFeatures = keyFeatures;
	}
	public String getAvailableFacilities() {
		return availableFacilities;
	}
	public void setAvailableFacilities(String availableFacilities) {
		this.availableFacilities = availableFacilities;
	}
	public int getVisitorCapacity() {
		return visitorCapacity;
	}
	public void setVisitorCapacity(int visitorCapacity) {
		this.visitorCapacity = visitorCapacity;
	}
	public String getInstaId() {
		return instaId;
	}
	public void setInstaId(String instaId) {
		this.instaId = instaId;
	}
	public String getFbId() {
		return fbId;
	}
	public void setFbId(String fbId) {
		this.fbId = fbId;
	}
	public String getWebsiteId() {
		return websiteId;
	}
	public void setWebsiteId(String websiteId) {
		this.websiteId = websiteId;
	}
	public String getYtId() {
		return ytId;
	}
	public void setYtId(String ytId) {
		this.ytId = ytId;
	}
	
	public Museum(String description) {
		super();
		this.description = description;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "Museum [mid=" + mid + ", muname=" + muname + ", city=" + city + ", state=" + state
				+ ", mapURL=" + mapURL + ", openingHours=" + openingHours + ", closingHours=" + closingHours
				+ ", openingDay=" + openingDay + ", closingDay=" + closingDay + ", contactNo=" + contactNo + ", email="
				+ email + ", keyFeatures=" + keyFeatures + ", availableFacilities=" + availableFacilities
				+ ", visitorCapacity=" + visitorCapacity + ", instaId=" + instaId + ", fbId=" + fbId + ", websiteId="
				+ websiteId + ", ytId=" + ytId + "]";
	}
	public Museum(int mid, String muname, String desc, String city, String state, String mapURL, String openingHours,
			String closingHours, String openingDay, String closingDay, String contactNo, String email,
			String keyFeatures, String availableFacilities, int visitorCapacity, String instaId, String fbId,
			String websiteId, String ytId) {
		super();
		this.mid = mid;
		this.muname = muname;
		this.city = city;
		this.state = state;
		this.mapURL = mapURL;
		this.openingHours = openingHours;
		this.closingHours = closingHours;
		this.openingDay = openingDay;
		this.closingDay = closingDay;
		this.contactNo = contactNo;
		this.email = email;
		this.keyFeatures = keyFeatures;
		this.availableFacilities = availableFacilities;
		this.visitorCapacity = visitorCapacity;
		this.instaId = instaId;
		this.fbId = fbId;
		this.websiteId = websiteId;
		this.ytId = ytId;
	}
	public Museum() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
    
    
    

}
