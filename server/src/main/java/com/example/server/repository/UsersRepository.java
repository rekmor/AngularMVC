package com.example.server.repository;

import com.example.server.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by RekMor on 10/26/17.
 */
public interface UsersRepository extends JpaRepository<Users, Integer>{

}
