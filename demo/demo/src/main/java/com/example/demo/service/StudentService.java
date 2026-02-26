package com.example.demo.service;

import com.example.demo.dta.CreateStudentDta;
import com.example.demo.dta.StudentDta;

import java.util.List;
import java.util.Map;

public interface StudentService {
    List<StudentDta> getAllStudents();

    StudentDta getStudentById(Long id);

    StudentDta createNewStudent(CreateStudentDta createStudentDta);

    void deleteStudent(Long id);


    StudentDta updateStudent(Long id, CreateStudentDta createStudentDta);

    StudentDta updateStudentPartially(Long id, Map<String, Object> updates);
}
