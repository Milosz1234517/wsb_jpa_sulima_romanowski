package com.jpacourse.persistance.dao.impl;

import com.jpacourse.persistance.dao.AddressDao;
import com.jpacourse.persistance.dao.DoctorDao;
import com.jpacourse.persistance.dao.PatientDao;
import com.jpacourse.persistance.entity.AddressEntity;
import com.jpacourse.persistance.entity.DoctorEntity;
import com.jpacourse.persistance.entity.PatientEntity;
import com.jpacourse.persistance.entity.VisitEntity;
import com.jpacourse.rest.exception.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@Repository
@AllArgsConstructor
public class PatientDaoImpl extends AbstractDao<PatientEntity, Long> implements PatientDao
{

    private DoctorDao doctorDao;

    public VisitEntity addVisitForPatient(Long patientId, Long doctorId, LocalDateTime visitDate, String visitDescr){
        PatientEntity patient = findOne(patientId);
        if(patient == null)
            throw new EntityNotFoundException(patientId);

        DoctorEntity doctor = doctorDao.findOne(doctorId);
        if(doctor == null)
            throw new EntityNotFoundException(doctorId);

        VisitEntity visitEntity = new VisitEntity();
        visitEntity.setPatientEntity(patient);
        visitEntity.setDoctorEntity(doctor);
        visitEntity.setTime(visitDate);
        visitEntity.setDescription(visitDescr);

        Collection<VisitEntity> patientVisitEntities = patient.getVisitEntities();
        patientVisitEntities.add(visitEntity);
        patient.setVisitEntities(patientVisitEntities);

        Collection<VisitEntity> doctorVisitEntities = doctor.getVisitEntities();
        doctorVisitEntities.add(visitEntity);
        doctor.setVisitEntities(doctorVisitEntities);

        save(patient);

        return visitEntity;
    }

    @Override
    public List<PatientEntity> findPatientsByLastName(String lastName) {
        return entityManager.createQuery(
                """
                   SELECT patient
                     FROM PatientEntity patient
                    WHERE patient.lastName like :param1
                   """, PatientEntity.class
        ).setParameter("param1", lastName)
                .getResultStream().toList();
    }

    @Override
    public List<VisitEntity> findVisitsByPstientID(Long patientID) {
        return entityManager.createQuery(
                        """
                           SELECT visits
                             FROM PatientEntity patient
                             JOIN patient.visitEntities visits
                            WHERE patient.id = :param1
                           """, VisitEntity.class
                ).setParameter("param1", patientID)
                .getResultStream().toList();
    }

    @Override
    public List<PatientEntity> findPatientsByVisitNumner(Integer visitNumner) {
        return null;
    }

    @Override
    public List<PatientEntity> findPatientsByPeselRange(Integer peselMin, Integer peselMax) {
        return null;
    }
}
