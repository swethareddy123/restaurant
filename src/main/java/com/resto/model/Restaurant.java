package com.resto.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Restaurant")
public class Restaurant {
	@Id
	private Long id;
 	private String name;
	private String address;
	private Long phoneNum;
	private String email;
	@ManyToOne(targetEntity = Dishes.class)
	//@JoinColumn(name="dishes")    
	private List<Dishes> dishes;
	public Restaurant() {}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Long getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(Long phoneNum) {
		this.phoneNum = phoneNum;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	  public List<Dishes> getDishes() { return dishes; } public void
	  setDishes(List<Dishes> dishes) { this.dishes = dishes; }
	public Restaurant(Long id, String name, String address, Long phoneNum, String email, List<Dishes> dishes) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.phoneNum = phoneNum;
		this.email = email;
		this.dishes = dishes;
	}
	@Override
	public String toString() {
		return "Restaurant [id=" + id + ", name=" + name + ", address=" + address + ", phoneNum=" + phoneNum
				+ ", email=" + email + ", dishes=" + dishes + "]";
	}
	 

	
	
	
	
	
}
