package com.example.server.repository;

import com.example.server.model.Engines;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

/**
 * Created by RekMor on 10/26/17.
 */
public interface EnginesRepository  extends JpaRepository<Engines, Integer>{
//public List<Engines> findByUsersId(int usersId);
}