package com.jpacourse.service;

import com.jpacourse.dto.AddressTO;
import com.jpacourse.dto.PatientTo;

import java.util.Optional;

public interface PatientService
{
    Optional<PatientTo> findById(final Long id);

    void delete(final Long id);
}
