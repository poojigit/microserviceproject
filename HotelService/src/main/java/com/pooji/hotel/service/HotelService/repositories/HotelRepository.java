package com.pooji.hotel.service.HotelService.repositories;

import com.pooji.hotel.service.HotelService.entities.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel, String> {
}
