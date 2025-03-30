package com.jpacourse.dto;

import com.jpacourse.persistance.entity.AddressEntity;
import com.jpacourse.persistance.entity.VisitEntity;
import com.jpacourse.persistance.enums.Specialization;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Collection;

@Getter
@Setter
public class DoctorTo {

    private Long id;

    private String firstName;

    private String lastName;

    private String telephoneNumber;

    private String email;

    private String doctorNumber;

    private Specialization specialization;

    private AddressTO addressEntity;

    private Collection<VisitTo> visitEntities;

}
