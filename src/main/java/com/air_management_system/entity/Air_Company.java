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
public class Air_Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String company_type;
    private String founded_at;
    @OneToMany(mappedBy = "airCompany")
    @JsonManagedReference
    private Set<Airplane>airplanes=new HashSet<>();
    @OneToMany(mappedBy = "airCompany")
    @JsonIgnore
    private Set<Flight>flights=new HashSet<>();

}
