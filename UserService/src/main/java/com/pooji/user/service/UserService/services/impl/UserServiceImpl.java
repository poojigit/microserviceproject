package com.pooji.user.service.UserService.services.impl;

import com.pooji.user.service.UserService.entities.Hotel;
import com.pooji.user.service.UserService.entities.Rating;
import com.pooji.user.service.UserService.entities.User;
import com.pooji.user.service.UserService.exceptions.ResourceNotFoundException;
import com.pooji.user.service.UserService.external.services.HotelService;
import com.pooji.user.service.UserService.repositories.UserRepository;
import com.pooji.user.service.UserService.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service

public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private HotelService hotelService;


    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);



    @Override
    public User saveUser(User user) {

        String randomUserID = UUID.randomUUID().toString();
        user.setUserId(randomUserID);
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUser() {

        return userRepository.findAll();
    }



    @Override
    public User getUser(String userId) {
        //get User from DB with the help of User repository
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User with given id is not found on server!!:" + userId));
        //fetch rating of the above user from Rating Service
        //http://localhost:8083/ratings/users/52521dd9-82fc-449f-b7a9-211ecec3ef6f
        Rating[] ratingsOfUser =restTemplate.getForObject("http://RATINGSERVICE/ratings/users/"+user.getUserId(), Rating[].class);
        logger.info("{}",ratingsOfUser);

        List<Rating>ratings= Arrays.stream(ratingsOfUser).toList();



        //for hotel

        List<Rating>ratingList=ratings.stream().map(rating-> {
            //api call to hotel service to get the hotel
            //ResponseEntity<Hotel> forEntity = restTemplate.getForEntity("http://HOTELSERVICE/hotels/"+rating.getHotelId(), Hotel.class);
            Hotel hotel = hotelService.getHotel(rating.getHotelId());
            //logger.info("response status code:{}",forEntity.getStatusCode());

            //set hotel ratings
            rating.setHotel(hotel);
            //return the ratings
            return rating;
        }).collect(Collectors.toList());
        user.setRating(ratingList);

        return user;
    }

    @Override
    public void deleteUser(String userId) {

    }


}


