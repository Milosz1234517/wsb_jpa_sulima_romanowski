package com.jpacourse.mapper;

import com.jpacourse.dto.DoctorTo;
import com.jpacourse.dto.MedicalTreatmentTo;
import com.jpacourse.dto.PatientTo;
import com.jpacourse.persistance.entity.MedicalTreatmentEntity;
import com.jpacourse.persistance.entity.PatientEntity;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;

@AllArgsConstructor
public final class MedicalTreatmentMapper {

    public static MedicalTreatmentTo mapToTo(MedicalTreatmentEntity medicalTreatmentEntity){
//        ModelMapper modelMapper = new ModelMapper();
//        return modelMapper.map(medicalTreatmentEntity, MedicalTreatmentTo.class);

        if (medicalTreatmentEntity == null) return null;

        MedicalTreatmentTo medicalTreatmentTo = new MedicalTreatmentTo();
        medicalTreatmentTo.setId(medicalTreatmentEntity.getId());
        medicalTreatmentTo.setType(medicalTreatmentEntity.getType());
        medicalTreatmentTo.setDescription(medicalTreatmentEntity.getDescription());
        return medicalTreatmentTo;
    }
}
