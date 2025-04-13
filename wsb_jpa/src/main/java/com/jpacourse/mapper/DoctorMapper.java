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
//        ModelMapper modelMapper = new ModelMapper();
//        return modelMapper.map(doctorEntity, DoctorTo.class);

          if (doctorEntity == null) return null;

          DoctorTo doctorTo = new DoctorTo();
          doctorTo.setDoctorNumber(doctorEntity.getDoctorNumber());
          doctorTo.setId(doctorEntity.getId());
          doctorTo.setEmail(doctorEntity.getEmail());
          doctorTo.setSpecialization(doctorEntity.getSpecialization());
          doctorTo.setFirstName(doctorEntity.getFirstName());
          doctorTo.setLastName(doctorEntity.getLastName());
          doctorTo.setTelephoneNumber(doctorEntity.getTelephoneNumber());
          doctorTo.setAddressEntity(AddressMapper.mapToTO(doctorEntity.getAddressEntity()));
          return doctorTo;
    }
}
