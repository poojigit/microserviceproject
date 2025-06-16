package com.pooji.rating.Rating.Service.impl;

import com.pooji.rating.Rating.Service.entities.Rating;
import com.pooji.rating.Rating.Service.repositories.RatingRepository;
import com.pooji.rating.Rating.Service.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingServiceImpl implements RatingService {

    @Autowired
    private RatingRepository repository;


    @Override
    public Rating create(Rating rating) {

        return repository.save(rating);
    }

    @Override
    public List<Rating> getRatings() {

        return repository.findAll();
    }

    @Override
    public List<Rating> getRatingByUserId(String userId) {

        return repository.findByUserId(userId);
    }

    @Override
    public List<Rating> getRatingByHotelId(String hotelId) {

        return repository.findByHotelId(hotelId);
    }
}
