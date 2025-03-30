package com.jpacourse.mapper;

import com.jpacourse.dto.PatientTo;
import com.jpacourse.persistance.entity.PatientEntity;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;

@AllArgsConstructor
public final class PatientMapper {

    public static PatientTo mapToTo(PatientEntity patientEntity){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(patientEntity, PatientTo.class);
    }
}
