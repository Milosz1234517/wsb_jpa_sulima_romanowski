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
}
