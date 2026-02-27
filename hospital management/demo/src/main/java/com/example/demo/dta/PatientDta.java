package com.example.demo.dta;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientDta {
    private String name;
    private LocalDate birthdate;
    private String email;
    private String gender;
}
