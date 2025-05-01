package com.jpacourse.persistance.dao;

import com.jpacourse.dto.PatientTo;
import com.jpacourse.persistance.entity.DoctorEntity;
import com.jpacourse.persistance.entity.PatientEntity;
import com.jpacourse.persistance.entity.VisitEntity;
import com.jpacourse.service.PatientService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@SpringBootTest
public class PatientDaoTest
{

    @Autowired
    private PatientDao patientDao;

    @Autowired
    private DoctorDao doctorDao;

    @Autowired
    private VisitDao visitDao;

    @Transactional
    @Test
    public void testAddPatientVisit() {
        // given
        Long patientId = 3L;
        Long doctorId = 1L;
        LocalDateTime visitDate = LocalDateTime.now();
        String descr = "test";

        int patientActualVisitsCount = patientDao.findOne(patientId).getVisitEntities().size();
        int doctorActualVisitsCount = doctorDao.findOne(doctorId).getVisitEntities().size();

        PatientEntity patientEntity = patientDao.findOne(patientId);

        // when
        VisitEntity visit = patientDao.addVisitForPatient(patientId, doctorId, visitDate, descr);

        // then
        Assertions.assertEquals(patientActualVisitsCount + 1, patientEntity.getVisitEntities().size());
        Assertions.assertEquals(doctorActualVisitsCount + 1, doctorDao.findOne(doctorId).getVisitEntities().size());

        Assertions.assertNotNull(visit);
        Assertions.assertNotNull(visitDao.findOne(visit.getId()));

        Assertions.assertEquals(visitDate, visit.getTime());
        Assertions.assertEquals(descr, visit.getDescription());
        Assertions.assertEquals(patientId, visit.getPatientEntity().getId());
        Assertions.assertEquals(doctorId, visit.getDoctorEntity().getId());
    }

    @Transactional
    @Test
    public void testFindPatientByLastname() {
        // GIVEN
        Long patientId = 3L;
        PatientEntity patientEntity = patientDao.findOne(patientId);

        // WHEN
        List<PatientEntity> patientResults = patientDao.findPatientsByLastName(patientEntity.getLastName());

        // THEN
        Assertions.assertEquals(patientResults.size(), 1);
        Assertions.assertEquals(patientResults.get(0).getId(), patientEntity.getId());
        Assertions.assertEquals(patientResults.get(0).getLastName(), patientEntity.getLastName());
        Assertions.assertEquals(patientResults.get(0).getFirstName(), patientEntity.getFirstName());
        Assertions.assertEquals(patientResults.get(0).getPatientNumber(), patientEntity.getPatientNumber());
        Assertions.assertEquals(patientResults.get(0).getEmail(), patientEntity.getEmail());
        Assertions.assertEquals(patientResults.get(0).getPesel(), patientEntity.getPesel());
        Assertions.assertEquals(patientResults.get(0).getTelephoneNumber(), patientEntity.getTelephoneNumber());
        Assertions.assertEquals(patientResults.get(0).getDateOfBirth(), patientEntity.getDateOfBirth());
        Assertions.assertEquals(patientResults.get(0).getEmail(), patientEntity.getEmail());
    }

    @Transactional
    @Test
    public void testFindPatientsWithVisitNumberGreaterThan() {
        // GIVEN
        Long patientId = 4L;
        PatientEntity patientEntity = patientDao.findOne(patientId);

        Integer visitNumber = 1;

        // WHEN
        List<PatientEntity> patientEntities = patientDao.findPatientsByVisitNumber(visitNumber);

        // THEN
        Assertions.assertEquals(patientEntities.size(), 1);
        Assertions.assertEquals(patientEntities.get(0).getId(), patientEntity.getId());
        Assertions.assertEquals(patientEntities.get(0).getLastName(), patientEntity.getLastName());
        Assertions.assertEquals(patientEntities.get(0).getFirstName(), patientEntity.getFirstName());
        Assertions.assertEquals(patientEntities.get(0).getPatientNumber(), patientEntity.getPatientNumber());
        Assertions.assertEquals(patientEntities.get(0).getEmail(), patientEntity.getEmail());
        Assertions.assertEquals(patientEntities.get(0).getPesel(), patientEntity.getPesel());
        Assertions.assertEquals(patientEntities.get(0).getTelephoneNumber(), patientEntity.getTelephoneNumber());
        Assertions.assertEquals(patientEntities.get(0).getDateOfBirth(), patientEntity.getDateOfBirth());
        Assertions.assertEquals(patientEntities.get(0).getEmail(), patientEntity.getEmail());
    }

    @Transactional
    @Test
    public void testFindPatientsWithPeselRange() {
        // GIVEN
        Long patientId = 5L;
        PatientEntity patientEntity = patientDao.findOne(patientId);

        Integer peselMin = 8;
        Integer peselMax = 13;

        // WHEN
        List<PatientEntity> patientEntities = patientDao.findPatientsByPeselRange(peselMin, peselMax);

        // THEN
        Assertions.assertEquals(patientEntities.size(), 1);
        Assertions.assertEquals(patientEntities.get(0).getId(), patientEntity.getId());
        Assertions.assertEquals(patientEntities.get(0).getLastName(), patientEntity.getLastName());
        Assertions.assertEquals(patientEntities.get(0).getFirstName(), patientEntity.getFirstName());
        Assertions.assertEquals(patientEntities.get(0).getPatientNumber(), patientEntity.getPatientNumber());
        Assertions.assertEquals(patientEntities.get(0).getEmail(), patientEntity.getEmail());
        Assertions.assertEquals(patientEntities.get(0).getPesel(), patientEntity.getPesel());
        Assertions.assertEquals(patientEntities.get(0).getTelephoneNumber(), patientEntity.getTelephoneNumber());
        Assertions.assertEquals(patientEntities.get(0).getDateOfBirth(), patientEntity.getDateOfBirth());
        Assertions.assertEquals(patientEntities.get(0).getEmail(), patientEntity.getEmail());
    }

    @Transactional
    @Test
    public void testFindPatientsWithManyVisits() {
        // GIVEN
        Long patientId = 4L;

        // WHEN
        PatientEntity patientEntity = patientDao.findOne(patientId);

        // THEN
        Assertions.assertEquals(patientEntity.getId(), patientId);
    }
}
