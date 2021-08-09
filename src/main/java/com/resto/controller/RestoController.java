package com.resto.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.resto.exception.RestoException;
import com.resto.model.Dishes;
import com.resto.model.Restaurant;
import com.resto.repo.RestoRepo;

@RestController
@RequestMapping("/resto")
@CrossOrigin(origins = "http://localhost:4200")
public class RestoController {

	@Autowired
	private RestoRepo restoRepo;
	
    @Autowired
    private RestTemplate restTemplate;

	@PostMapping("/addRestaurant")
	public Restaurant addRestaurantDetails(@RequestBody Restaurant restaurantDetails) {
		return restoRepo.save(restaurantDetails);
	}
	
	@GetMapping("/getAllRestaurants")
	public List<Restaurant> getAllRestaurantDetails(){
		List<Restaurant> restaurantList = restoRepo.findAll();
		for(Restaurant restaurant : restaurantList) {
		List<Dishes> dishes = this.restTemplate.getForObject("http://dishes-service/dish/getdishesById/" + restaurant.getId(), List.class);
		restaurant.setDishes(dishes);
		}
		return restaurantList;
	}
	
	@GetMapping("/getRestaurantById/{id}")
	public Restaurant getRestaurantDetails(@PathVariable Long id) throws RestoException{
		Restaurant restaurant = restoRepo.findById(id).orElse(null);
		List<Dishes> dishes = this.restTemplate.getForObject("http://dishes-service/dish/getdishesById/" + restaurant.getId(), List.class);
	    restaurant.setDishes(dishes);
		return restaurant;
	}
	
	@DeleteMapping("/deleteRestaurant/{id}")
	public void deleteRestaurantDetails(@PathVariable Long id) {
		restoRepo.deleteById(id);
	}
	
	@PutMapping("/updateRestaurantDetails")
	public Restaurant updateRestaurant(@RequestBody Restaurant restaurantDetails) {
		Restaurant existingRestaurantDetails=restoRepo.findById(restaurantDetails.getId()).orElse(null);
		existingRestaurantDetails.setAddress(restaurantDetails.getAddress());
		existingRestaurantDetails.setEmail(restaurantDetails.getEmail());
		existingRestaurantDetails.setName(restaurantDetails.getName());
		existingRestaurantDetails.setPhoneNum(restaurantDetails.getPhoneNum());
		return restoRepo.save(existingRestaurantDetails);
	}	
}
