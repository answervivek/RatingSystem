package com.trilectus.rating.service.services;

import com.trilectus.rating.service.entities.Rating;

import java.util.List;

public interface RatingService {

    //createRating
    public Rating createRating(Rating rating);

    //getAllRating
    public List<Rating> getAllRating();

    //getAllRatingByUserId
    public List<Rating> getRatingByUserId(String userId);

    //getAllRatingByHotelId
    public List<Rating> getRatingByHotelId(String hotelId);

}
