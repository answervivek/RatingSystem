package com.trilectus.hotel.service.services;

import com.trilectus.hotel.service.entites.Hotel;

import java.util.List;

public interface HotelService {

    //create
    Hotel createHotel(Hotel hotel);

    //getall
    List<Hotel> getAllHotels();

    //getsingle
    Hotel getHotelById(String id);
}
