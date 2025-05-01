package com.jpacourse.service;

import com.jpacourse.dto.AddressTO;
import com.jpacourse.dto.PatientTo;
import com.jpacourse.dto.VisitTo;
import com.jpacourse.persistance.entity.PatientEntity;
import com.jpacourse.persistance.entity.VisitEntity;

import java.util.List;
import java.util.Optional;

public interface PatientService
{
    Optional<PatientTo> findById(final Long id);

    public List<VisitTo> findVisitsByPatientID(Long patientId);

    void delete(final Long id);
}
