package com.example.server.controller;

import com.example.server.Service.EnginesService;
import com.example.server.model.Engines;
import com.example.server.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by RekMor on 10/26/17.
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")

public class EnginesController {

    @Autowired
    private EnginesService enginesService;


    @RequestMapping("/Users/Engines")
    public List<Engines> getAllEngines( ){
        return enginesService.getAllEngines();
    }



    @RequestMapping("Users/{usersId}/Engines/{id}")
    public Engines getEngine( @PathVariable int id){

        return enginesService.getEngine(id);

    }

    @RequestMapping(method = RequestMethod.PUT, value = "/Engine/{id}")
    public void updateEngine (@PathVariable int usersId, @PathVariable int id, @RequestBody Engines engine){
        engine.setUser(new Users(usersId,"","",'\0','\0'));
        enginesService. updateEngine(engine);
    }


    @RequestMapping(method = RequestMethod.POST, value = "/Users/{usersId}/Engines")
    public void addEngine (@RequestBody Engines engine, @PathVariable int usersId)
    {
       engine.setUser(new Users(usersId,"","",'\0','\0'));
        enginesService.addEngine(engine);
    }


    @RequestMapping(method = RequestMethod.DELETE, value = "/Users/{userId}/Engines/{id}")
    public void deleteEngine (@PathVariable int id)
    {
        enginesService.deleteEngine(id);
    }

}

