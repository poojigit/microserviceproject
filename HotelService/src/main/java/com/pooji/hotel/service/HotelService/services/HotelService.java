package com.pooji.hotel.service.HotelService.services;

import com.pooji.hotel.service.HotelService.entities.Hotel;

import java.util.List;

public interface HotelService {

    //create
    Hotel create(Hotel hotel);

    //getAll

    List<Hotel> getAll();

    //getSingle

    Hotel get(String id);


}
