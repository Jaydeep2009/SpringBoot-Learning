package com.example.demo.dta;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;


import java.time.LocalDate;

@Data
public class CreatePatientDta {
    @NotBlank
    private String name;
    private LocalDate birthdate;

    @Email(message = "Email format is invalid")
    private String email;

    private String gender;
}
