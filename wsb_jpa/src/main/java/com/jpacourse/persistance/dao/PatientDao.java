package com.jpacourse.persistance.dao;

import com.jpacourse.persistance.dao.Dao;
import com.jpacourse.persistance.entity.AddressEntity;
import com.jpacourse.persistance.entity.PatientEntity;
import com.jpacourse.persistance.entity.VisitEntity;

import java.time.LocalDateTime;

public interface PatientDao extends Dao<PatientEntity, Long>
{
    VisitEntity addVisitForPatient(Long patientId, Long doctorId, LocalDateTime visitDate, String visitDescr);
}
