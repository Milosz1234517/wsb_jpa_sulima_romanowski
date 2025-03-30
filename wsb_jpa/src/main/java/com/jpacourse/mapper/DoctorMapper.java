package com.jpacourse.mapper;

import com.jpacourse.dto.DoctorTo;
import com.jpacourse.dto.PatientTo;
import com.jpacourse.persistance.entity.DoctorEntity;
import com.jpacourse.persistance.entity.PatientEntity;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;

import javax.print.Doc;

@AllArgsConstructor
public final class DoctorMapper {

    public static DoctorTo mapToTo(DoctorEntity doctorEntity){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(doctorEntity, DoctorTo.class);
    }
}
