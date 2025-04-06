package com.jpacourse.dto;

import com.jpacourse.persistance.entity.AddressEntity;
import com.jpacourse.persistance.entity.VisitEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Collection;

@Getter
@Setter
public class PatientTo {

    private Long id;

    private String firstName;

    private String lastName;

    private String telephoneNumber;

    private String email;

    private String patientNumber;

    private Integer pesel;

    private LocalDate dateOfBirth;

    private Collection<VisitTo> visitEntities;

    private AddressEntity addressEntity;
}
