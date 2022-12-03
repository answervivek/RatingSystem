package com.trilectus.rating.service.controller;

import com.trilectus.rating.service.entities.Rating;
import com.trilectus.rating.service.services.RatingService;
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

    //Create a new rating
    @PostMapping
    public ResponseEntity<Rating> createRating(@RequestBody Rating rating) {
        return ResponseEntity.status(HttpStatus.CREATED).body(ratingService.createRating(rating));
    }

    //Get All Rating
    @GetMapping
    public ResponseEntity<List<Rating>> getAllRatings() {
        return ResponseEntity.status(HttpStatus.OK).body(ratingService.getAllRating());
    }

    //Get All Rating By User Id
    @GetMapping("/users/{userId}")
    public ResponseEntity<List<Rating>> getAllRatingsByUserId(@PathVariable String userId) {
        return ResponseEntity.status(HttpStatus.OK).body(ratingService.getRatingByUserId(userId));
    }

    //Get All Rating By Hotel Id
    @GetMapping("/hotels/{hotelId}")
    public ResponseEntity<List<Rating>> getAllRatingsByHotelId(@PathVariable String hotelId) {
        return ResponseEntity.status(HttpStatus.OK).body(ratingService.getRatingByHotelId(hotelId));
    }

}
