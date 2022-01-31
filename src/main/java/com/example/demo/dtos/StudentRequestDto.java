package com.example.demo.dtos;

import com.example.demo.Bos.StudentBo;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class StudentRequestDto {

    @NotNull(message = "id cannot be empty")
    private String id;
    @NotNull(message = "name cannot be empty")
    @Size(min = 2, max = 30, message = "name must be 2-30 characters long")
    private String name;
    @Size(min = 2, max = 30, message = "major must be 2-30 characters long")
    @NotNull(message = "major cannot be empty")
    private String major;

    public StudentRequestDto(String id, String name, String major) {
        this.id = id;
        this.name = name;
        this.major = major;
    }

    public StudentBo requestDtoToBo() {
        return new StudentBo(this.id, this.name, this.major);
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
