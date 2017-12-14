package com.example.server.Service;

import com.example.server.model.Users;
import com.example.server.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by RekMor on 11/2/17.
 */
@Service
public class UsersService {
    @Autowired
    private UsersRepository usersRepository;


    public List<Users> getAllUsers(){
        List<Users> users = new ArrayList<>();
        usersRepository.findAll()
                .forEach(users::add);
        return users;
    }

    public Users getUser(int id){
        return usersRepository.findOne(id);

    }

    public void addUser(Users user){
        usersRepository.save(user);

    }


    public void deleteUser(int id) {

        usersRepository.delete(id);
    }

    public void updateUser(int id, Users user) {

        usersRepository.save(user);
    }
}
