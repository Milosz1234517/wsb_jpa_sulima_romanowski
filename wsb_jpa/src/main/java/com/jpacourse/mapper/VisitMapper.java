package com.jpacourse.mapper;

import com.jpacourse.dto.MedicalTreatmentTo;
import com.jpacourse.dto.PatientTo;
import com.jpacourse.dto.VisitTo;
import com.jpacourse.persistance.entity.PatientEntity;
import com.jpacourse.persistance.entity.VisitEntity;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;

@AllArgsConstructor
public final class VisitMapper {

    public static VisitTo mapToTo(VisitEntity visitEntity){
//        ModelMapper modelMapper = new ModelMapper();
//        return modelMapper.map(visitEntity, VisitTo.class);

        if (visitEntity == null) return null;

        VisitTo visitTo = new VisitTo();
        visitTo.setId(visitEntity.getId());
        visitTo.setDescription(visitEntity.getDescription());
        visitTo.setTime(visitEntity.getTime());
        visitTo.setDoctorEntity(DoctorMapper.mapToTo(visitEntity.getDoctorEntity()));
        visitTo.setMedicalTreatmentEntities(visitEntity.getMedicalTreatmentEntities().stream().map(MedicalTreatmentMapper::mapToTo).toList());
        return visitTo;
    }
}
