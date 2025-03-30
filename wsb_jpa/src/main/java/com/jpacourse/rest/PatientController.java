package com.jpacourse.rest;

import com.jpacourse.dto.AddressTO;
import com.jpacourse.dto.PatientTo;
import com.jpacourse.rest.exception.EntityNotFoundException;
import com.jpacourse.service.AddressService;
import com.jpacourse.service.PatientService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class PatientController
{

    private final PatientService patientService;
    @GetMapping("/patient/{id}")
    PatientTo findBaId(@PathVariable final Long id) {
        return patientService.findById(id).orElseThrow(() -> new EntityNotFoundException(id));
    }
}
