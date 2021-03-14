package com.air_management_system.entity;

import com.fasterxml.jackson.annotation.*;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Setter
@Getter
@Entity
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Enumerated(value = EnumType.STRING)
    private Status status;
    private String departure_country;
    private String destination_country;
    private Integer distance;
    private Integer estimated_flight_time;
    private LocalDateTime ended_at;
    private LocalDateTime delay_started_at;
    private LocalDateTime created_at;
    @ManyToOne
    @JsonIgnore
    private Air_Company airCompany;
    @ManyToOne
    @JsonBackReference
    private Airplane airplane;
}
