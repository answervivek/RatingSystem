package com.trilectus.user.service.repository;

import com.trilectus.user.service.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface UserRepository extends JpaRepository<User, String> {

}
