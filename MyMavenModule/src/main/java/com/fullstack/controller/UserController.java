package com.fullstack.controller;

import com.fullstack.dao.ProjectRepository;
import com.fullstack.dao.UserRepository;
import com.fullstack.data.Project;
import com.fullstack.data.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("fullstack")

public class UserController {
    @Autowired
    UserRepository userRepo;

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping (path = "/user")
    public void user(@RequestBody User user){
        userRepo.save(user);

    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping  (path = "/user")
    public List<User> user(){
        return (List<User>) userRepo.findAll();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping  (path = "/user/{name}")
    public List<User> user(@PathVariable String name){

        return (List<User>) userRepo.findByLastName(name);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping (path = "/user/{userId}")
    public void removeUser(@PathVariable long userId){
        System.out.println("Deleted "  +userId);
        User user = userRepo.findByUserId(userId);
        userRepo.delete(user);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping (path = "/user")
    public void updateUser(@RequestBody User user){
        System.out.println("updated "  +user.getUserId());

        User originalUser = userRepo.findByUserId(user.getUserId());
        originalUser.setFirstName(user.getFirstName());
        originalUser.setLastName(user.getLastName());
        userRepo.save(originalUser);
    }


}
