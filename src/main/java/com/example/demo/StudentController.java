package com.example.demo;

import com.example.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public Response<Student> getStudent(@PathVariable String id) {
        Student responseData = studentService.getStudent(id);
        if (responseData != null) {
            return new Response<Student>(true, "", responseData);
        } else {
            return new Response<Student>(false, String.format("Invalid student id %s", id), null);
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = "/students")
    public Response<Student> addStudent(@RequestBody Student student) {
        boolean success = studentService.addStudent(student);
        if (success) {
            return new Response<Student>(true, String.format("Student with id %s added successfully", student.getId()), null);
        }
        return new Response<Student>(false, String.format("Student with id %s already exists", student.getId()), null);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/students/{id}")
    public Response<Student> updateStudent(@RequestBody Student student, @PathVariable String id) {
        boolean success = studentService.updateStudent(id, student);
        if (success) {
            return new Response<Student>(true, String.format("Student with id %s updated successfully", id), null);
        }
        return new Response<Student>(false, String.format("Invalid student id %s", id), null);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/students/{id}")
    public Response<Student> deleteStudent(@PathVariable String id) {
        boolean success = studentService.deleteStudent(id);
        if (success) {
            return new Response<Student>(true, String.format("Student with id %s deleted successfully", id), null);
        }
        return new Response<Student>(false, String.format("Invalid student id %s", id), null);
    }
}
