package com.jpacourse.service.impl;

import com.jpacourse.dto.PatientTo;
import com.jpacourse.dto.VisitTo;
import com.jpacourse.mapper.PatientMapper;
import com.jpacourse.mapper.VisitMapper;
import com.jpacourse.persistance.dao.PatientDao;
import com.jpacourse.persistance.entity.PatientEntity;
import com.jpacourse.persistance.entity.VisitEntity;
import com.jpacourse.rest.exception.EntityNotFoundException;
import com.jpacourse.service.PatientService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
@Transactional
@AllArgsConstructor
public class PatientServiceImpl implements PatientService
{
    private final PatientDao patientDao;

    @Override
    public Optional<PatientTo> findById(Long id) {
        return Optional.ofNullable(PatientMapper.mapToTo(patientDao.findOne(id)));
    }

    @Override
    public List<VisitTo> findVisitsByPatientID(Long patientId){
        return patientDao.findVisitsByPatientID(patientId)
                .stream()
                .map(VisitMapper::mapToTo)
                .toList();
    }

    @Override
    public void delete(Long id){
        PatientTo patientEntity = findById(id).orElseThrow(() -> new EntityNotFoundException(id));
        patientDao.delete(patientEntity.getId());
    }
}
