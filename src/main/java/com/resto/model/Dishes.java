
 package com.resto.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Dishes {
	@Id
  	private Long dishId;
  	private String dishname;
  	private int price;
  	private String desctiption;
  	private Long id;
  	
  	public Long getDishId() {
  		return dishId;
  	}
  	public void setDishId(Long dishId) {
  		this.dishId = dishId;
  	}
  	public String getDishname() {
  		return dishname;
  	}
  	public void setDishname(String dishname) {
  		this.dishname = dishname;
  	}
  	public int getPrice() {
  		return price;
  	}
  	public void setPrice(int price) {
  		this.price = price;
  	}
  	public String getDesctiption() {
  		return desctiption;
  	}
  	public void setDesctiption(String desctiption) {
  		this.desctiption = desctiption;
  	}
  	

  	public Dishes() {
  	}
  	public Long getId() {
  		return id;
  	}
  	public void setId(Long id) {
  		this.id = id;
  	}
  	public Dishes(Long dishId, String dishname, int price, String desctiption, Long id) {
  		super();
  		this.dishId = dishId;
  		this.dishname = dishname;
  		this.price = price;
  		this.desctiption = desctiption;
  		this.id = id;
  	}
  	@Override
  	public String toString() {
  		return "Dishes [dishId=" + dishId + ", dishname=" + dishname + ", price=" + price + ", desctiption="
  				+ desctiption + ", id=" + id + "]";
  	}
  	

  }
 