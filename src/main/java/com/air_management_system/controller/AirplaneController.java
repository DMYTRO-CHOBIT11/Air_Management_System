package com.air_management_system.controller;

import com.air_management_system.dao.AirplaneDAO;
import com.air_management_system.entity.Airplane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AirplaneController {
    @Autowired
    private AirplaneDAO airplaneDAO;

    @GetMapping("/getAirplane/{id}")
    public ResponseEntity getAirplaneById(@PathVariable long id){
        return  new ResponseEntity(airplaneDAO.getAirplane(id), HttpStatus.OK);
    }

    @PostMapping("/createAirplane")
    public ResponseEntity createAirplane(@RequestBody Airplane airplane){
        return new ResponseEntity(airplaneDAO.addAirplane(airplane),HttpStatus.OK);
    }

    @GetMapping("/getAllAirplane")
    public ResponseEntity getAllAirplane(){
        return new ResponseEntity(airplaneDAO.allAirplane(),HttpStatus.OK);
    }

    @DeleteMapping("/deleteAirplane/{id}")
    public ResponseEntity deleteAirplaneById(@PathVariable long id){
        return new ResponseEntity(airplaneDAO.deleteAirplane(id),HttpStatus.OK);
    }
}
