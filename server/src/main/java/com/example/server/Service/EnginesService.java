package com.example.server.Service;

import com.example.server.model.Engines;
import com.example.server.repository.EnginesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by RekMor on 11/2/17.
 */
@Service
public class EnginesService {
    @Autowired

    private EnginesRepository enginesRepository;


    public List<Engines> getAllEngines(){
        List<Engines> engines = new ArrayList<>();
        enginesRepository.findAll()
                .forEach(engines::add);
        return engines;
    }

    public Engines getEngine(int id){
        return enginesRepository.findOne(id);

    }

    public void addEngine(Engines engine){
        enginesRepository.save(engine);

    }


    public void deleteEngine(int id) {

        enginesRepository.delete(id);
    }

    public void updateEngine(Engines engine) {

        enginesRepository.save(engine);
    }
}
