package com.pooji.user.service.UserService.external.services;

import com.pooji.user.service.UserService.entities.Rating;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "RATING-SERVICE")
public interface RatingService  {
    @PostMapping("/ratings")
    public Rating createRating(Rating values);
}
