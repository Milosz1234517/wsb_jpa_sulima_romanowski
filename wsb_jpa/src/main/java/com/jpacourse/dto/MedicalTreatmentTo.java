package com.jpacourse.dto;

import com.jpacourse.persistance.entity.VisitEntity;
import com.jpacourse.persistance.enums.TreatmentType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MedicalTreatmentTo {

    private Long id;

    private String description;

    private TreatmentType type;

    private VisitTo visitEntity;

}
