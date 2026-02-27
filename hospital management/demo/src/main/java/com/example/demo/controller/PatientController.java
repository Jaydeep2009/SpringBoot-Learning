package com.example.demo.controller;

import com.example.demo.dta.CreatePatientDta;
import com.example.demo.dta.PatientDta;
import com.example.demo.service.PatientServices;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class PatientController {
    public final PatientServices patientServices;

    @PostMapping("/patients")
    public ResponseEntity<PatientDta> createPatient(@RequestBody CreatePatientDta createPatientDta) {
        return ResponseEntity.status(HttpStatus.CREATED).body(patientServices.createPatient(createPatientDta));
    }
}
