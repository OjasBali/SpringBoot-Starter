package com.example.demo;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class StudentService {

    private final List<Student> students = new ArrayList<>(Arrays.asList(
            new Student("001", "John", "Computer Science"),
            new Student("002", "Bob", "Combinato    rics & Optimization"),
            new Student("003", "Alice", "Statistics")
    ));

    public List<Student> getAllStudents() {
        return students;
    }

    public Student getStudent(String id) {
        return students.stream().filter(s -> s.getId().equals(id)).findFirst().get();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void updateStudent(String id, Student student) {
        for (Student s: students) {
            if (s.getId().equals(id)) {
                s.setName(student.getName());
                s.setMajor(student.getMajor());
                return;
            }
        }
    }

    public void deleteStudent(String id) {
        students.removeIf(s -> s.getId().equals(id));
    }
}
