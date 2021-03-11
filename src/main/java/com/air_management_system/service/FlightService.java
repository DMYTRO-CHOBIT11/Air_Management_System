package com.air_management_system.service;

import com.air_management_system.dao.FlightDAO;
import com.air_management_system.entity.Airplane;
import com.air_management_system.entity.Flight;
import com.air_management_system.entity.Status;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.time.*;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FlightService implements FlightDAO {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public String addFlight(Flight flight) {
        flight.setStatus(Status.PENDING);
        Airplane airplane=entityManager.find(Airplane.class,flight.getAirplane().getId());
        flight.setAirCompany(airplane.getAirCompany());
        return "Flight with ID: "+flight.getId()+" was created";
    }

    @Override
    @Transactional
    public String deleteFlight(long id) {
        Optional<Flight>flight=Optional.ofNullable(entityManager.find(Flight.class,id));
        if (flight.isPresent()){
            entityManager.createNativeQuery("delete from Flight where id=:id", Flight.class)
                    .setParameter("id",id)
                    .executeUpdate();
        }else throw new NoSuchElementException("Flight with ID: "+id+" is not exist");

        return "Flight with ID: "+id+" was deleted";
    }

    @Override
    @Transactional
    public Optional<Flight> getFlight(long id) {
        Optional<Flight>flight=Optional.ofNullable(entityManager.find(Flight.class,id));
        if (!flight.isPresent()){
            throw new NoSuchElementException("Flight with ID: "+id+" is not exist");
        }
        return flight;
    }

    @Override
    @Transactional
    public List<Flight> allFlight() {
        return entityManager.createQuery("select f from Flight  f",Flight.class)
                .getResultList();
    }

    @Override
    public String updateFlight(long id, Flight flight) {
        entityManager.createQuery("update Flight set status=:newStatus where id=:id",Flight.class)
                .setParameter("newStatus",flight.getStatus())
                .setParameter("id",id)
                .executeUpdate();
        return "Status was changed";
    }

    @Override
    public List<Flight> allFlightWithActiveStatusAndDelayMore24h() {
        List<Flight>flights=allFlight();
        LocalDateTime localDateTime=LocalDateTime.now();
        return flights.stream().filter(flight -> {
            Duration duration=Duration.between(flight.getCreated_at(), localDateTime);
            long h=Duration.ofHours(duration.toHours()).toHours();
            if (flight.getStatus().toString().equals("ACTIVE") && h>24){
                return true;
            }return false;
        }).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public String changeFlightStatus(long flightID,String newStatus) {
        Optional<Flight> flight=getFlight(flightID);
        if (!flight.isPresent()){
            throw new NoSuchElementException("Flight with ID: "+flightID+" not exist");
        }
        if(newStatus.equals("ACTIVE")){
            flight.get().setStatus(Status.ACTIVE);
            flight.get().setCreated_at(LocalDateTime.now());
        }else if(newStatus.equals("DELAYED")){
            flight.get().setStatus(Status.DELAYED);
            flight.get().setDelay_started_at(LocalDateTime.now());
        }else if (newStatus.equals("COMPLETED")){
            flight.get().setStatus(Status.COMPLETED);
            flight.get().setEnded_at(LocalDateTime.now());
        }
        entityManager.persist(flight.get());
        return "Status changed successfully!!!";
    }

    @Override
    public List<Flight> completedStatusAndDifferentInTime() {
        List<Flight>flights=allFlight();
        return flights.stream().filter(flight ->{
            long hours=Duration.between(flight.getCreated_at(),flight.getEnded_at()).toHours();
            return (flight.getStatus().toString().equals("COMPLETED") & hours > flight.getEstimated_flight_time());
        }).collect(Collectors.toList());
    }
}
