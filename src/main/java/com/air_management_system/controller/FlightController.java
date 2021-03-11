package com.air_management_system.controller;

import com.air_management_system.dao.FlightDAO;
import com.air_management_system.entity.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class FlightController {
    @Autowired
    private FlightDAO flightDAO;

    @GetMapping("/getFlight/{id}")
    public ResponseEntity getFlightById(@PathVariable long id){
        return  new ResponseEntity(flightDAO.getFlight(id), HttpStatus.OK);
    }

    @PostMapping("/createFlight")
    public ResponseEntity createFlight(@RequestBody Flight flight){
        return new ResponseEntity(flightDAO.addFlight(flight),HttpStatus.OK);
    }

    @GetMapping("/getAllFlight")
    public ResponseEntity getAllFlight(){
        return new ResponseEntity(flightDAO.allFlight(),HttpStatus.OK);
    }

    @DeleteMapping("/deleteFlight/{id}")
    public ResponseEntity deleteFlightById(@PathVariable long id){
        return new ResponseEntity(flightDAO.deleteFlight(id),HttpStatus.OK);
    }

    @GetMapping("/flightMore24h")
    public ResponseEntity allFlightWithActiveStatusAndDelayMore24h(){
        return new ResponseEntity(flightDAO.allFlightWithActiveStatusAndDelayMore24h(),HttpStatus.OK);
    }

    @PostMapping("/changeFlightStatus/{id}")
    public ResponseEntity changeFlightStatus(@PathVariable long id,@RequestParam String status){
        return new ResponseEntity(flightDAO.changeFlightStatus(id,status),HttpStatus.OK);
    }

    @GetMapping("/completedStatus")
    public ResponseEntity completedStatusAndDifferentInTime(){
        return new ResponseEntity(flightDAO.completedStatusAndDifferentInTime(),HttpStatus.OK);
    }
}
