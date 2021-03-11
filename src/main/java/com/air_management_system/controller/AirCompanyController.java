package com.air_management_system.controller;

import com.air_management_system.dao.AirCompanyDAO;
import com.air_management_system.entity.Air_Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AirCompanyController {
    @Autowired
    private AirCompanyDAO airCompanyDAO;

    @GetMapping("/getAirCompany/{companyID}")
    public ResponseEntity getCompany(@PathVariable("companyID") long id){
        return new ResponseEntity(airCompanyDAO.getAirCompany(id), HttpStatus.OK);
    }

    @PostMapping("/addAirCompany")
    public ResponseEntity addAirCompany(@RequestBody Air_Company airCompany){
        return new ResponseEntity(airCompanyDAO.addAirCompany(airCompany),HttpStatus.OK);
    }

    @GetMapping("/getAllAirCompany")
    public ResponseEntity getAllCompany(){
        return new ResponseEntity(airCompanyDAO.allAirCompany(), HttpStatus.OK);
    }

    @DeleteMapping("/deleteAirCompany/{companyID}")
    public ResponseEntity deleteCompany(@PathVariable("companyID")long id){
        return  new ResponseEntity(airCompanyDAO.deleteAirCompany(id),HttpStatus.OK);
    }

    @GetMapping("/flightByStatus/{status}")
    public ResponseEntity companyByStatus(@PathVariable String status){
        return new ResponseEntity(airCompanyDAO.findAllFlightByStatus(status),HttpStatus.OK);
    }

    @PostMapping("/changeOwnerAirplane")
    public ResponseEntity updateCompany(@RequestParam long companyID,long airplaneID){
        return new ResponseEntity(airCompanyDAO.changeOwnerAirplane(airplaneID,companyID),HttpStatus.OK);
    }
}
