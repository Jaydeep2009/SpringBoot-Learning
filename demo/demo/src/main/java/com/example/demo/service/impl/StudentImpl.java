package com.example.demo.service.impl;

import com.example.demo.dta.CreateStudentDta;
import com.example.demo.dta.StudentDta;
import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class StudentImpl implements StudentService {
    public final StudentRepository studentRepository;
    public final ModelMapper modelMapper = new ModelMapper();
    @Override
    public List<StudentDta> getAllStudents() {
        List<Student> students = studentRepository.findAll();
        return students.stream()
                .map(
                        student -> modelMapper.map(student ,StudentDta.class)
                ).toList();
    }

    @Override
    public StudentDta getStudentById(Long id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("Student not found: "+id));

        return modelMapper.map(student,StudentDta.class);

    }

    @Override
    public StudentDta createNewStudent(CreateStudentDta createStudentDta) {
        Student student = modelMapper.map(createStudentDta,Student.class);
        student= studentRepository.save(student);

        return modelMapper.map(student,StudentDta.class);
    }

    @Override
    public void deleteStudent(Long id) {
        if(!studentRepository.existsById(id)){
            throw new IllegalArgumentException("Student not found: "+id);
        }

        studentRepository.deleteById(id);
    }

    @Override
    public StudentDta updateStudent(Long id, CreateStudentDta createStudentDta) {
        Student student = studentRepository
                .findById(id)
                .orElseThrow(()-> new IllegalArgumentException("Student not found: "+id));

        modelMapper.map(createStudentDta,student);
        Student newStudent= studentRepository.save(student);

        return modelMapper.map(newStudent,StudentDta.class);

    }

    @Override
    public StudentDta updateStudentPartially(Long id, Map<String, Object> updates) {
        Student student = studentRepository
                .findById(id)
                .orElseThrow(()-> new IllegalArgumentException("Student not found: "+id));

        updates.forEach((field,value)->{
            switch (field){
                case "name":
                    student.setName((String) value);
                    break;

                case "email":
                    student.setEmail((String) value);
                    break;

                default:
                    throw new IllegalArgumentException("Field invalid");
            }
        });
        Student saveStudent = studentRepository.save(student);

        return modelMapper.map(saveStudent,StudentDta.class);
    }

    @Override
    public void deleteAll() {
        studentRepository.deleteAll();
    }


}
