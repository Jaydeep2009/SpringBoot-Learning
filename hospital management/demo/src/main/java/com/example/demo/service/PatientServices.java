package com.example.demo.service;

import com.example.demo.dta.CreatePatientDta;
import com.example.demo.dta.PatientDta;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


public interface PatientServices {

    PatientDta createPatient(CreatePatientDta createPatientDta);
}
