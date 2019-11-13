package br.com.sanfelice.microservices.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.sanfelice.microservices.user.entity.User;
import br.com.sanfelice.microservices.user.service.UserService;

/**
 * UserController
 */
@RestController
@RequestMapping(value = "/")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService service) {
        this.userService = service;
    }

    @GetMapping("/members")
    public ResponseEntity<Iterable<User>> getAll() {

        Iterable<User> all = userService.findAll();

        return new ResponseEntity<>(all, HttpStatus.OK);
    }

    @GetMapping("/register")
    public ResponseEntity<User> register(@RequestBody User input) {

        User result = userService.registerUser(input);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    
}