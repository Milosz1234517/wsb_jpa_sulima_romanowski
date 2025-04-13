package com.jpacourse.persistance.dao;

import com.jpacourse.dto.AddressTO;
import com.jpacourse.dto.PatientTo;
import com.jpacourse.dto.VisitTo;
import com.jpacourse.persistance.entity.AddressEntity;
import com.jpacourse.persistance.entity.DoctorEntity;
import com.jpacourse.persistance.entity.PatientEntity;
import com.jpacourse.persistance.entity.VisitEntity;
import com.jpacourse.rest.exception.EntityNotFoundException;
import com.jpacourse.service.PatientService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

@SpringBootTest
public class PatientServiceTest {
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

        Long doctorIdDb = doctorDao.findOne(doctorId).getId();
        Long visitIdDb = visitDao.findOne(visitId).getId();
        Long addressIdDb = addressDao.findOne(patientAddressId).getId();
        Long patientIdDb = patientDao.findOne(patientId).getId();

        // when
        patientService.delete(patientId);

        // then

        Assertions.assertNull(patientDao.findOne(patientIdDb));
        Assertions.assertNull(addressDao.findOne(addressIdDb));
        Assertions.assertNull(visitDao.findOne(visitIdDb));
        Assertions.assertNotNull(doctorDao.findOne(doctorIdDb));
    }

    @Transactional
    @Test
    public void testGetPatientPesel() {
        // given

        Long patientId = 1L;
        Integer pesel = 1;
        String firstName = "Tadeusz";
        String lastName = "But";
        String telephoneNumber = "123456789";
        String email = "p1@gmail.com";
        String patientNumber = "1";
        LocalDate dateOfBirth = LocalDate.of(1999, 7, 11);

        // when
        Optional<PatientTo> patient = patientService.findById(patientId);

        // then
        PatientTo patientTo = patient.get();
        Assertions.assertNotNull(patientTo);
        Assertions.assertEquals(pesel, patientTo.getPesel());
        Assertions.assertEquals(firstName, patientTo.getFirstName());
        Assertions.assertEquals(lastName, patientTo.getLastName());
        Assertions.assertEquals(telephoneNumber, patientTo.getTelephoneNumber());
        Assertions.assertEquals(email, patientTo.getEmail());
        Assertions.assertEquals(patientNumber, patientTo.getPatientNumber());
        Assertions.assertEquals(dateOfBirth, patientTo.getDateOfBirth());
    }
}
