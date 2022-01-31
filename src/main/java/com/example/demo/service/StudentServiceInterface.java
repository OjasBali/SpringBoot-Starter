package com.example.demo.service;

import com.example.demo.Bos.StudentBo;
import com.example.demo.models.Student;

import java.util.List;

public interface StudentServiceInterface {

    // what is difference between abstract class and interface
    // hashMap, set working ?
    // factory ?
    // Java Design patterns ?
        // Factory
    // abstract factory
    // singleton - DB Connection
    // chain or

    // Authentication
    // request- Header (Authtentication: xyz) -> error: 403 forbidden
    // types of HTTP error codes

    // Validation, how validation work
    // javax validation - HINT
    // field if null throw (422)

    // 500 - internal server error

    // don't use application properties
    // use yaml configuration


    // DB Connection Pool


    // datasource- DB
    // cache - Redis ?
    List<StudentBo> getAllStudents();
    StudentBo getStudent(String id);
    void addStudent(StudentBo student);
    void updateStudent(String id, StudentBo student);
    void deleteStudent(String id);
}
