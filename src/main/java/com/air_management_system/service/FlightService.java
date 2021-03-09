package com.air_management_system.service;

import com.air_management_system.dao.FlightDAO;
import com.air_management_system.entity.Flight;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class FlightService implements FlightDAO {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public String addFlight(Flight flight) {
        entityManager.persist(flight);
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
}
