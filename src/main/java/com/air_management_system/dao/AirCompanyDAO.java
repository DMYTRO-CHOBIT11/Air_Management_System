package com.air_management_system.dao;

import com.air_management_system.entity.Air_Company;
import com.air_management_system.entity.Flight;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AirCompanyDAO {
    String addAirCompany(Air_Company airCompany);
    String deleteAirCompany(long id);
    Optional<Air_Company> getAirCompany(long id);
    List<Air_Company> allAirCompany();
    String updateAirCompany(long id,Air_Company airCompany);
    List<Flight> findAllCompanyByStatus(String status);
}
