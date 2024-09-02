package com.example.demo.model;

import java.util.List;

import jakarta.persistence.*;

@Entity
public class Package {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pid;
	private String pname;
	private String price;
	@ElementCollection  // Annotate the List to tell JPA it's a collection of basic types
	@CollectionTable(name = "package_details", joinColumns = @JoinColumn(name = "package_id"))
	@Column(name = "detail")
	private List<String> l;
	private String validity;
	private int group_size;
	private int availablity;
	private String package_type;
	private String termsandc;
    @ManyToOne
    @JoinColumn(name = "mid")  // Foreign key column in the Package table
    private Museum museum;
    
	public Package(Museum museum) {
		super();
		this.museum = museum;
	}
	public Museum getMuseum() {
		return museum;
	}
	public void setMuseum(Museum museum) {
		this.museum = museum;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public List<String> getL() {
		return l;
	}
	public void setL(List<String> l) {
		this.l = l;
	}
	public String getValidity() {
		return validity;
	}
	public void setValidity(String validity) {
		this.validity = validity;
	}
	public int getGroup_size() {
		return group_size;
	}
	public void setGroup_size(int group_size) {
		this.group_size = group_size;
	}
	public int getAvailablity() {
		return availablity;
	}
	public void setAvailablity(int availablity) {
		this.availablity = availablity;
	}
	public String getPackage_type() {
		return package_type;
	}
	public void setPackage_type(String package_type) {
		this.package_type = package_type;
	}
	public String getTermsandc() {
		return termsandc;
	}
	public void setTermsandc(String termsandc) {
		this.termsandc = termsandc;
	}
	@Override
	public String toString() {
		return "Package [pid=" + pid + ", pname=" + pname + ", price=" + price + ", l=" + l + ", validity=" + validity
				+ ", group_size=" + group_size + ", availablity=" + availablity + ", package_type=" + package_type
				+ ", termsandc=" + termsandc + "]";
	}
	public Package(int pid, String pname, String price, List<String> l, String validity, int group_size,
			int availablity, String package_type, String termsandc) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.price = price;
		this.l = l;
		this.validity = validity;
		this.group_size = group_size;
		this.availablity = availablity;
		this.package_type = package_type;
		this.termsandc = termsandc;
	}
	public Package() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
