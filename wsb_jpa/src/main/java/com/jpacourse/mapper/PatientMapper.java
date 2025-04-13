package com.jpacourse.mapper;

import com.jpacourse.dto.DoctorTo;
import com.jpacourse.dto.PatientTo;
import com.jpacourse.persistance.entity.PatientEntity;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;

@AllArgsConstructor
public final class PatientMapper {

    public static PatientTo mapToTo(PatientEntity patientEntity){
//        ModelMapper modelMapper = new ModelMapper();
//        return modelMapper.map(patientEntity, PatientTo.class);

        if (patientEntity == null) return null;

        PatientTo patientTo = new PatientTo();
        patientTo.setPatientNumber(patientEntity.getPatientNumber());
        patientTo.setId(patientEntity.getId());
        patientTo.setEmail(patientEntity.getEmail());
        patientTo.setPesel(patientEntity.getPesel());
        patientTo.setFirstName(patientEntity.getFirstName());
        patientTo.setLastName(patientEntity.getLastName());
        patientTo.setTelephoneNumber(patientEntity.getTelephoneNumber());
        patientTo.setDateOfBirth(patientEntity.getDateOfBirth());
        patientTo.setAddressEntity(AddressMapper.mapToTO(patientEntity.getAddressEntity()));
        patientTo.setVisitEntities(patientEntity.getVisitEntities().stream().map(VisitMapper::mapToTo).toList());
        return patientTo;

    }
}
