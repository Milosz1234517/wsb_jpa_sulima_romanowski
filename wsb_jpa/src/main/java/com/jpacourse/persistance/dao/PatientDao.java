package com.jpacourse.persistance.dao;

import com.jpacourse.persistance.dao.Dao;
import com.jpacourse.persistance.entity.AddressEntity;
import com.jpacourse.persistance.entity.PatientEntity;
import com.jpacourse.persistance.entity.VisitEntity;

import java.time.LocalDateTime;
import java.util.List;

public interface PatientDao extends Dao<PatientEntity, Long>
{
    VisitEntity addVisitForPatient(Long patientId, Long doctorId, LocalDateTime visitDate, String visitDescr);

    List<PatientEntity> findPatientsByLastName(String lastName);

    List<VisitEntity> findVisitsByPstientID(Long patientID);

    List<PatientEntity> findPatientsByVisitNumner(Integer visitNumner);

    List<PatientEntity> findPatientsByPeselRange(Integer peselMin, Integer peselMax);
}
