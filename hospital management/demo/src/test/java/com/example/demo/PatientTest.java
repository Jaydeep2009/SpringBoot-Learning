package com.example.demo;

import com.example.demo.entity.Patient;
import com.example.demo.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class PatientTest {
    @Autowired
    private PatientRepository patientRepository;


    @Test
    public void testPatientRepository() {
        // This is a placeholder test method. You can add actual tests for the PatientRepository here.

        List<Patient> patientList= patientRepository.findAll();
        System.out.println(patientList);
        System.out.println("PatientRepository test executed successfully.");
    }
}
