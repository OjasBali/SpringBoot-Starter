package Student;

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

    public void addStudent(Student student) {
        studentRepository.save(student);
    }

    public void updateStudent(String id, Student student) {
        if (studentRepository.existsById(id))
            studentRepository.save(student);
    }

    public void deleteStudent(String id) {
        studentRepository.deleteById(id);
    }
}
