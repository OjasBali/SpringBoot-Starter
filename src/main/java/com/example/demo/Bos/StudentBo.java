package com.example.demo.Bos;

import com.example.demo.dtos.StudentRequestDto;
import com.example.demo.dtos.StudentResponseDto;
import com.example.demo.models.Student;

public class StudentBo {

    private String id;
    private String name;
    private String major;

    public StudentBo(String id, String name, String major) {
        this.id = id;
        this.name = name;
        this.major = major;
    }

    public StudentBo(Student student) {
        this.id = student.getId();
        this.name = student.getName();
        this.major = student.getMajor();
    }

    public Student boToEntity() {
        return new Student(this.id, this.name, this.major);
    }

    public StudentResponseDto boToResponseDto() {
        return new StudentResponseDto(this.id, this.name, this.major);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }
}
