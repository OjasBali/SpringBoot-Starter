package com.example.demo.controller;

import com.example.demo.Bos.StudentBo;
import com.example.demo.dtos.StudentRequestDto;
import com.example.demo.dtos.StudentResponseDto;
import com.example.demo.models.Student;
import com.example.demo.service.StudentServiceInterface;
import com.example.demo.service.impl.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentServiceInterface studentService;

    @RequestMapping("/students")
    public List<StudentResponseDto> getAllStudents() {
        List<StudentBo> studentBos = studentService.getAllStudents();
        List<StudentResponseDto> studentResponseDtos = new ArrayList<>();
        studentBos.forEach(s -> studentResponseDtos.add(s.boToResponseDto()));
        return studentResponseDtos;
    }

    @RequestMapping("/students/{id}")
    public StudentResponseDto getStudent(@PathVariable String id) {
        return studentService.getStudent(id).boToResponseDto();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/students")
    public void addStudent(@Valid @RequestBody StudentRequestDto studentRequestDto) {
        studentService.addStudent(studentRequestDto.requestDtoToBo());
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/students/{id}")
    public void updateStudent(@Valid @RequestBody StudentRequestDto studentRequestDto, @PathVariable String id) {
        studentService.updateStudent(id, studentRequestDto.requestDtoToBo());
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/students/{id}")
    public void deleteStudent(@PathVariable String id) {
        studentService.deleteStudent(id);
    }

}
