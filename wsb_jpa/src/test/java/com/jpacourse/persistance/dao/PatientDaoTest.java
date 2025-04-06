package com.jpacourse.persistance.dao;

import com.jpacourse.dto.PatientTo;
import com.jpacourse.persistance.entity.PatientEntity;
import com.jpacourse.persistance.entity.VisitEntity;
import com.jpacourse.service.PatientService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@SpringBootTest
public class PatientDaoTest
{

    @Autowired
    private PatientDao patientDao;

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

        PatientEntity patientEntity = patientDao.findOne(patientId);

        // when
        patientDao.addVisitForPatient(patientId, doctorId, visitDate, descr);

        // then
        Assertions.assertEquals(1, patientEntity.getVisitEntities().size());

        VisitEntity visit = (VisitEntity) patientEntity.getVisitEntities().toArray()[0];
        Assertions.assertNotNull(visit);
        Assertions.assertNotNull(visitDao.findOne(visit.getId()));
    }
}
