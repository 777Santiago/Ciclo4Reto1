package com.usa.reto1.reto1.controller;

import com.usa.reto1.reto1.model.User;
import com.usa.reto1.reto1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@CrossOrigin("*")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public List<User> getAll(){
        return userService.getAll();
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public User toRegister(@RequestBody User user){
        return userService.toRegister(user);
    }

    @GetMapping("/{email}/{password}")
    public User authenticateUser(@PathVariable("email") String email, @PathVariable("password") String password){
        return userService.authenticateUser(email, password);
    }

    @GetMapping("/{email}")
    public boolean existsEmail(@PathVariable("email") String email){
        return userService.existsEmail(email);
    }
}
