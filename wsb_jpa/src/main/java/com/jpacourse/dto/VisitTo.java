package com.jpacourse.dto;

import com.jpacourse.persistance.entity.DoctorEntity;
import com.jpacourse.persistance.entity.MedicalTreatmentEntity;
import com.jpacourse.persistance.entity.PatientEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Collection;

@Getter
@Setter
public class VisitTo {

    private Long id;

    private String description;

    private LocalDateTime time;

    private DoctorTo doctorEntity;

//    private PatientTo patientEntity;

    private Collection<MedicalTreatmentTo> medicalTreatmentEntities;

}
