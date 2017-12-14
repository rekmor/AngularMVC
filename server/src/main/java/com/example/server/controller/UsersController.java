package com.example.server.controller;

import com.example.server.Service.UsersService;
import com.example.server.model.Users;
import com.example.server.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by RekMor on 10/26/17.
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")

public class UsersController {

    @Autowired
    private UsersService usersService;

//    @Autowired
//    UsersRepository usersRepository;

    @RequestMapping("/Users")
    public List<Users> getAllUsers(){
        return usersService.getAllUsers();
    }

    @RequestMapping("/Users/{id}")
    public Users getUser(@PathVariable int id){
        return usersService.getUser(id);

    }

    @RequestMapping(method = RequestMethod.PUT, value = "/Users/{id}")
    public void updateUser ( @PathVariable int id, @RequestBody Users user){
        usersService. updateUser(id, user);
    }


    @RequestMapping(method = RequestMethod.POST, value = "/Users")
    public void addUser (@RequestBody Users user){
        usersService.addUser(user);
    }


    @RequestMapping(method = RequestMethod.DELETE, value = "/Users/{id}")
    public void deleteUser (@PathVariable int id){
        usersService.deleteUser(id);
    }

}

