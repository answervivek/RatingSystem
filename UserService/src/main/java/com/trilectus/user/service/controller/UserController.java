package com.trilectus.user.service.controller;

import com.trilectus.user.service.entities.User;
import com.trilectus.user.service.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    //Create User
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User createUser = userService.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(createUser);
    }

    //Get Single User
    @GetMapping("/{userId}")
    public ResponseEntity<User> getUser(@PathVariable("userId") String userId) {
        User user = userService.getUser(userId);
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }

    //Get All Users
    @GetMapping
    public ResponseEntity<Iterable<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return ResponseEntity.status(HttpStatus.OK).body(users);
    }
}
