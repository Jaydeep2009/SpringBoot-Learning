package com.example.demo.service.impl;

import com.example.demo.dta.CreatePatientDta;
import com.example.demo.dta.PatientDta;
import com.example.demo.entity.Patient;
import com.example.demo.repository.PatientRepository;
import com.example.demo.service.PatientServices;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PatientServicesImpl implements PatientServices {
    private final PatientRepository patientRepository;
    private final ModelMapper modelMapper = new ModelMapper();

    @Override
    public PatientDta createPatient(CreatePatientDta createPatientDta) {
        Patient patient = modelMapper.map(createPatientDta, Patient.class);
        patient=patientRepository.save(patient);
        return modelMapper.map(patient,PatientDta.class);
    }
}
