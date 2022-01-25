package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        studentRepository.findAll().forEach(students::add);
        return students;
    }

    public Student getStudent(String id) {
        return studentRepository.findById(id).isPresent()
                ? studentRepository.findById(id).get()
                : null;
    }

    public boolean addStudent(Student student) {
        if (studentRepository.existsById(student.getId())) {
            return false;
        }
        studentRepository.save(student);
        return true;
    }

    public boolean updateStudent(String id, Student student) {
        if (studentRepository.existsById(id)) {
            studentRepository.save(student);
            return true;
        }
        return false;
    }

    public boolean deleteStudent(String id) {
        if (studentRepository.existsById(id)) {
            studentRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
