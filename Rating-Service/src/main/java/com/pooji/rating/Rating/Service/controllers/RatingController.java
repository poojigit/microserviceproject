package com.pooji.rating.Rating.Service.controllers;

import com.pooji.rating.Rating.Service.entities.Rating;
import com.pooji.rating.Rating.Service.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingController {


    @Autowired
    private RatingService ratingService;


    //create rating

    @PostMapping
    public ResponseEntity<Rating> create (@RequestBody Rating rating){
        return ResponseEntity.status(HttpStatus.CREATED).body(ratingService.create(rating));

    }

    //get all rating

    @GetMapping
    public ResponseEntity<List<Rating>>getRating(){

        return ResponseEntity.ok(ratingService.getRatings());
    }



    //get by userId

    @GetMapping("/users/{userId}")
    public ResponseEntity<List<Rating>>getRatingsByUserId(@PathVariable String userId){
        return ResponseEntity.ok(ratingService.getRatingByUserId(userId));
    }

    @GetMapping("/hotels/{hotelId}")
    public ResponseEntity<List<Rating>>getRatingsByHotelId(@PathVariable String hotelId){
        return ResponseEntity.ok(ratingService.getRatingByHotelId(hotelId));
    }


}
