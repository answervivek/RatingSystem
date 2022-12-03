package com.trilectus.hotel.service.repository;

import com.trilectus.hotel.service.entites.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel, String> {

}
