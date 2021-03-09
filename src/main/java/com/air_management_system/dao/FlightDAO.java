package com.air_management_system.dao;

import com.air_management_system.entity.Flight;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FlightDAO {
    String addFlight(Flight flight);
    String deleteFlight(long id);
    Optional<Flight> getFlight(long id);
    List<Flight> allFlight();
    String updateFlight(long id,Flight flight);
}
