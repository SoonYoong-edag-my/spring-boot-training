package com.example.demo.service;

import com.example.demo.dto.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class StudentService {

    private List<Student> students;

    public StudentService() {
        this.students = new ArrayList<>();
    }

    public List<Student> getStudents() {
        return students;
    }

    public Student createStudent(Student student) {
        student.setId(UUID.randomUUID().toString());
        students.add(student);
        return student;
    }

    public Student updateStudent(String studentId, Student student) {
        Student existingStudent = students.stream().filter(s -> s.getId().equalsIgnoreCase(studentId)).findAny().orElse(null);
        existingStudent.setFirstName(student.getFirstName());
        existingStudent.setLastName(student.getLastName());
        return existingStudent;
    }

    public void deleteStudent(String studentId) {
        Student existingStudent = students.stream().filter(s -> s.getId().equalsIgnoreCase(studentId)).findAny().orElse(null);
        if (existingStudent != null) {
            students.remove(existingStudent);
        }

    }
}
