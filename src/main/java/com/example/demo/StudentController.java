package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping("/students")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @RequestMapping("/students/{id}")
    public Student getStudent(@PathVariable String id) {
        return studentService.getStudent(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/students")
    public void addStudent(@RequestBody Student student) {
        studentService.addStudent(student);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/students/{id}")
    public void updateStudent(@RequestBody Student student, @PathVariable String id) {
        studentService.updateStudent(id, student);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/students/{id}")
    public void deleteStudent(@PathVariable String id) {
        studentService.deleteStudent(id);
    }

}
