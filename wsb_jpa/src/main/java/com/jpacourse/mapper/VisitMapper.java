package com.jpacourse.mapper;

import com.jpacourse.dto.PatientTo;
import com.jpacourse.dto.VisitTo;
import com.jpacourse.persistance.entity.PatientEntity;
import com.jpacourse.persistance.entity.VisitEntity;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;

@AllArgsConstructor
public final class VisitMapper {

    public static VisitTo mapToTo(VisitEntity visitEntity){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(visitEntity, VisitTo.class);
    }
}
