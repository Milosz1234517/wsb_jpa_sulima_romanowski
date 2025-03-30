package com.jpacourse.persistance.dao;

import com.jpacourse.persistance.entity.AddressEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class PatientDaoTest
{
    @Autowired
    private PatientDao patientDao;

    @Transactional
    @Test
    public void testShouldDeletePatientById() {
        // given
        // when
        // then
    }
}
