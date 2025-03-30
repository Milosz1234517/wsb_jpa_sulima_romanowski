package com.jpacourse.mapper;

import com.jpacourse.dto.MedicalTreatmentTo;
import com.jpacourse.dto.PatientTo;
import com.jpacourse.persistance.entity.MedicalTreatmentEntity;
import com.jpacourse.persistance.entity.PatientEntity;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;

@AllArgsConstructor
public final class MedicalTreatmentMapper {

    public static MedicalTreatmentTo mapToTo(MedicalTreatmentEntity medicalTreatmentEntity){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(medicalTreatmentEntity, MedicalTreatmentTo.class);
    }
}
