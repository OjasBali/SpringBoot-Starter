package com.example.demo.service.impl;

import com.example.demo.Bos.StudentBo;
import com.example.demo.models.Student;
import com.example.demo.repo.StudentRepository;
import com.example.demo.service.StudentServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService implements StudentServiceInterface {

    //API level
    // controller - rest API
    // DTO - data transfer object

    // validation level
    // validation - Request

    // service layer
    // BO - Business object

    // DB Layer
    // Entity

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<StudentBo> getAllStudents() {
        List<StudentBo> students = new ArrayList<>();
        studentRepository.findAll().forEach(student -> students.add(new StudentBo(student)));
        return students;
    }

    public StudentBo getStudent(String id) {
        return new StudentBo(studentRepository.findById(id).get());
    }

    public void addStudent(StudentBo studentBo) {
        studentRepository.save(studentBo.boToEntity());
    }

    public void updateStudent(String id, StudentBo studentBo) {
        if (studentRepository.existsById(id))
            studentRepository.save(studentBo.boToEntity());
    }

    public void deleteStudent(String id) {
        studentRepository.deleteById(id);
    }
}
