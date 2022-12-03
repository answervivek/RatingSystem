package com.trilectus.user.service.services;

import com.trilectus.user.service.entities.User;

import java.util.List;

public interface UserService {

    //Save User
    User saveUser(User user);

    //Get All Users
    List<User> getAllUsers();

    //Get User by Id
    User getUser(String userId);

}
