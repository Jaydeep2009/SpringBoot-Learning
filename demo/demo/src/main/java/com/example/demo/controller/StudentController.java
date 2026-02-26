package com.example.demo.controller;

import com.example.demo.dta.CreateStudentDta;
import com.example.demo.dta.StudentDta;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.StudentService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@AllArgsConstructor
@RequestMapping("/students")
public class StudentController {
    public final StudentService studentService;

    @GetMapping
    public ResponseEntity<List<StudentDta>>getAllStudents(){
        return ResponseEntity.ok(studentService.getAllStudents());
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDta> getStudentById(@PathVariable Long id){
        return ResponseEntity.ok(studentService.getStudentById(id));
    }

    @PostMapping()
    public ResponseEntity<StudentDta> createStudent(@RequestBody @Valid CreateStudentDta createStudentDta){
        return ResponseEntity.status(HttpStatus.CREATED).body(studentService.createNewStudent(createStudentDta));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id){
        studentService.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentDta> updateStudent
            (@PathVariable Long id, @RequestBody @Valid CreateStudentDta createStudentDta)
    {
        return ResponseEntity.status(HttpStatus.CREATED).body(studentService.updateStudent(id,createStudentDta));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<StudentDta> updateStudentPartially
            (@PathVariable Long id, @RequestBody Map<String, Object>updates)
    {
        return ResponseEntity.status(HttpStatus.CREATED).body(studentService.updateStudentPartially(id,updates));
    }

    @DeleteMapping("/deleteAll")
    public ResponseEntity<Void> deleteAll(){
        studentService.deleteAll();
        return ResponseEntity.noContent().build();
    }
}
