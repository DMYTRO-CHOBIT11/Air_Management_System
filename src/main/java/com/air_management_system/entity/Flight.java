package com.air_management_system.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

@Setter
@Getter
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Enumerated(value = EnumType.STRING)
    private Status status;
    private String departure_country;
    private String destination_country;
    private int distance;
    private int estimated_flight_time;
    private String ended_at;
    private Date delay_started_at;
    private String created_at;
    @ManyToOne
    private Air_Company airCompany;
    @ManyToOne
    private Airplane airplane;

}
