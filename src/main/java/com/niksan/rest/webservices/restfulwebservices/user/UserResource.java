package com.niksan.rest.webservices.restfulwebservices.user;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.time.LocalDate;
import java.util.List;

@RestController
public class UserResource {

    private UserDaoService service;

    public UserResource(UserDaoService service) {
        this.service = service;
    }

    @GetMapping("users")
    public List<User> retrieveAllUsers(){
        return service.findAll();
    }

    @GetMapping("users/{userId}")
    public User retrieveUser(@PathVariable int userId){
        User user = service.findUserById(userId);
        if(user == null){
            throw new  UserNotFoundException("id: " + userId);
        }
        return user;
    }

    @PostMapping("users")
    public ResponseEntity<User> createUser(@RequestBody User user){
        User savedUser = service.save(user);
        URI location =
                ServletUriComponentsBuilder
                        .fromCurrentRequest()
                        .path("/{id}")
                        .buildAndExpand(savedUser.getId())
                        .toUri();
        return ResponseEntity.created(location).build();

    }
}
