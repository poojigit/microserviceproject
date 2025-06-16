package com.pooji.hotel.service.HotelService.impl;

import com.pooji.hotel.service.HotelService.entities.Hotel;
import com.pooji.hotel.service.HotelService.exceptions.ResourceNotFoundException;
import com.pooji.hotel.service.HotelService.repositories.HotelRepository;
import com.pooji.hotel.service.HotelService.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class HotelServiceImpl  implements HotelService {

    @Autowired
    private HotelRepository hotelRepository;
    @Override
    public Hotel create(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    @Override
    public List<Hotel> getAll() {
        return hotelRepository.findAll();
    }

    @Override
    public Hotel get(String id) {
        return hotelRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Hotel with the given id not found"));
    }
}
