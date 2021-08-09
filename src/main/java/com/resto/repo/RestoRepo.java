package com.resto.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.resto.model.Restaurant;

@Repository
public interface RestoRepo extends MongoRepository<Restaurant, Long>{

}
