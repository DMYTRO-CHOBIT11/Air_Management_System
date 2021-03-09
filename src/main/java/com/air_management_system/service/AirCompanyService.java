package com.air_management_system.service;

import com.air_management_system.dao.AirCompanyDAO;
import com.air_management_system.entity.Air_Company;
import com.air_management_system.entity.Flight;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class AirCompanyService implements AirCompanyDAO {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public String addAirCompany(Air_Company airCompany) {
        entityManager.persist(airCompany);
        return "Air Company with ID: "+airCompany.getId()+" was created";
    }

    @Override
    @Transactional
    public String deleteAirCompany(long id) {
        Optional<Air_Company>company=Optional.ofNullable(entityManager.find(Air_Company.class,id));
        if (company.isPresent()){
            company.get().getFlights().forEach(flight ->
                    entityManager.createNativeQuery("delete from Flight where id=:id")
                            .setParameter("id",flight.getId())
                            .executeUpdate());

            company.get().getAirplanes().forEach(airplane ->
                    entityManager.createNativeQuery("delete from Airplane where id=:id")
                            .setParameter("id",airplane.getId())
                            .executeUpdate());

            entityManager.createNativeQuery("delete from Air_Company where id=:id")
                    .setParameter("id",id)
                    .executeUpdate();
        }else {
            throw new NoSuchElementException("Company with ID: "+id+" not exist!");
        }
        return "Company with ID: "+id+" was deleted";
    }


    @Override
    @Transactional
    public Optional<Air_Company> getAirCompany(long id) {
        Optional<Air_Company> company;
        try {
            company=Optional.ofNullable(entityManager
                    .createQuery("select company from Air_Company company where company.id=:id",Air_Company.class)
                    .setParameter("id",id).getSingleResult());
        }catch (NoResultException e){
            throw new NoSuchElementException("Company with ID: "+id+" not exist!");
        }
        return company;
    }

    @Override
    @Transactional
    public List<Air_Company> allAirCompany() {
        return entityManager.createQuery("select company from Air_Company company",Air_Company.class)
                .getResultList();
    }

    @Override
    @Transactional
    public String updateAirCompany(long id, Air_Company airCompany) {
        entityManager.createQuery("update Air_Company set name=:name,company_type=:company_type," +
                "founded_at=:founded_at",Air_Company.class)
                .setParameter("name",airCompany.getName())
                .setParameter("company_type",airCompany.getCompany_type())
                .setParameter("founded_at",airCompany.getFounded_at())
                .executeUpdate();
        return "Company with ID: "+id+" was updated";
    }

    @Override
    public List<Flight> findAllCompanyByStatus(String status) {
        List<Air_Company>companyList=allAirCompany();
        List<Flight>flightsByStatus=new ArrayList<>();
        companyList.forEach(airCompany -> airCompany.getFlights().forEach(flight ->
        {
            if (flight.getStatus().toString().equals(status)) {
                flightsByStatus.add(flight);
            }
        }));
        flightsByStatus.forEach(System.out::println);
        return flightsByStatus;
    }
}
