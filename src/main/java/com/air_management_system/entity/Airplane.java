package com.air_management_system.entity;

import com.fasterxml.jackson.annotation.*;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@Entity
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
public class Airplane {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String factory_serial_number;
    private int number_of_flights;
    private long flight_distance;
    private int fuel_capacity;
    private String type;
    private String created_at;
    @ManyToOne
    @JsonBackReference
    private Air_Company airCompany;
    @OneToMany(mappedBy = "airplane")
    @JsonManagedReference
    private Set<Flight> flights=new HashSet<>();
}
