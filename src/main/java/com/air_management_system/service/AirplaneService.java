package com.air_management_system.service;

import com.air_management_system.dao.AirplaneDAO;
import com.air_management_system.entity.Airplane;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class AirplaneService implements AirplaneDAO {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public String addAirplane(Airplane airplane) {
        entityManager.persist(airplane);
        return "Airplane with ID: "+airplane.getId()+" was created";
    }

    @Override
    @Transactional
    public String deleteAirplane(long id) {
        Optional<Airplane> airplane=Optional.ofNullable(entityManager.find(Airplane.class,id));
        if (airplane.isPresent()){
            airplane.get().getFlights().forEach(flight ->
                    entityManager.createNativeQuery("delete from Flight where id=:id")
                            .setParameter("id",flight.getId())
                            .executeUpdate());

            entityManager.createQuery("delete from Airplane where id=:id")
                    .setParameter("id",id)
                    .executeUpdate();

        }else throw new NoSuchElementException("Airplane with ID: "+id+" not exist!");

        return "Airplane with ID: "+id+" was deleted";
    }

    @Override
    @Transactional
    public Optional<Airplane> getAirplane(long id) {
        Optional<Airplane>airplane;
        try {
            airplane=Optional.ofNullable(entityManager.createQuery("select a from Airplane a where a.id=:id",Airplane.class)
                    .setParameter("id",id)
                    .getSingleResult());
        }catch (NoResultException e){
            throw new NoSuchElementException("Airplane with ID: "+id+" is not exist");

        }
        return airplane;
    }

    @Override
    @Transactional
    public List<Airplane> allAirplane() {
        return entityManager.createQuery("select a from Airplane  a ",Airplane.class)
                .getResultList();
    }

//    @Override
//    public String updateCompanyForAirplane(long id, Airplane airplane) {
//        return null;
//    }
}
