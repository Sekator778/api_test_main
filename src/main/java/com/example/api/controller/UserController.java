package com.example.api.controller;

import com.example.api.dto.User;
import com.example.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable(value = "id") Long userId) {
        return userService.findById(userId);
    }

    @PostMapping
    public boolean save(@RequestBody User user) {
        return userService.create(user);
    }

    @PutMapping
    public boolean update(@RequestBody User user) {
        return userService.update(user);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable(value = "id") Long userId) {
        return userService.delete(userId);
    }
}
