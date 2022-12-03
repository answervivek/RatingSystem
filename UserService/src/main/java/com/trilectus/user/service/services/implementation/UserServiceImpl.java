package com.trilectus.user.service.services.implementation;

import com.trilectus.user.service.entities.Hotel;
import com.trilectus.user.service.entities.Rating;
import com.trilectus.user.service.entities.User;
import com.trilectus.user.service.exceptions.ResourseNotFoundExceptions;
import com.trilectus.user.service.externalServices.HotelService;
import com.trilectus.user.service.repository.UserRepository;
import com.trilectus.user.service.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
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

    @Override
    public User saveUser(User user) {
        String uuid = UUID.randomUUID().toString();
        user.setUserId(uuid);
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(String userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourseNotFoundExceptions("User not found with id: " + userId));
        String url = "http://RATING-SERVICE/ratings/users/" + user.getUserId();

        Rating[] ratingObject = restTemplate.getForObject(url, Rating[].class);
        List<Rating> ratings = Arrays.stream(ratingObject).toList();

        List<Rating> ratingList = ratings.stream().map(rating -> {
            //Call Hotel Service
//            String hotelUrl = "http://HOTEL-SERVICE/hotels/" + rating.getHotelId();
//            ResponseEntity<Hotel> forEntity = restTemplate.getForEntity(hotelUrl, Hotel.class);
//            Hotel hotel = forEntity.getBody();
            Hotel hotel = hotelService.getHotelById(rating.getHotelId());
            //Set Hotel
            rating.setHotel(hotel);
            // Return Rating
            return rating;

        }).collect(Collectors.toList());

        user.setRatings(ratingList);

        return user;
    }
}
