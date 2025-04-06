package com.jpacourse.persistance.dao;

import com.jpacourse.dto.PatientTo;
import com.jpacourse.persistance.entity.PatientEntity;
import com.jpacourse.rest.exception.EntityNotFoundException;
import com.jpacourse.service.PatientService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

@SpringBootTest
public class PatientServiceTest
{
    @Autowired
    private PatientService patientService;

    @Autowired
    private PatientDao patientDao;

    @Autowired
    private AddressDao addressDao;

    @Autowired
    private VisitDao visitDao;

    @Autowired
    private DoctorDao doctorDao;

    @Transactional
    @Test
    public void testShouldDeletePatientById() {
        // given
        Long patientId = 1L;
        Long patientAddressId = 3L;
        Long visitId = 1L;
        Long doctorId = 1L;

        // when
        patientService.delete(patientId);

        // then
        Assertions.assertNull(patientDao.findOne(patientId));
        Assertions.assertNull(addressDao.findOne(patientAddressId));
        Assertions.assertNull(visitDao.findOne(visitId));
        Assertions.assertNotNull(doctorDao.findOne(doctorId));
    }

    @Transactional
    @Test
    public void testGetPatientPesel() {
        // given
        Long patientId = 1L;
        Integer pesel = 1;

        // when
        Optional<PatientTo> patient = patientService.findById(patientId);

        // then
        Assertions.assertNotNull(patient.get());
        Assertions.assertEquals(pesel, patient.get().getPesel());
    }
}
