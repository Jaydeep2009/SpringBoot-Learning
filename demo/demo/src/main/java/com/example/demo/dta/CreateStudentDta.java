package com.example.demo.dta;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CreateStudentDta {
    @NotBlank(message = "name is required")
    @Size(min=1,max=30, message = "The name length should be between 1-30")
    private String name;

    @Email(message = "Email format is invalid")
    @NotBlank(message = "Email is required!")
    private String email;
}
