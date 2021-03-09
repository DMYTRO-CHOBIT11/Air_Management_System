package com.air_management_system.dao;

import com.air_management_system.entity.Airplane;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AirplaneDAO {
    String addAirplane(Airplane airplane);
    String deleteAirplane(long id);
    Optional<Airplane> getAirplane(long id);
    List<Airplane> allAirplane();
    String updateAirplane(long id,Airplane airplane);
}
