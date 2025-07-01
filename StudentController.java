package com.example.controller;

import com.example.model.Student;
import com.example.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    // CREATE
    @PostMapping
    public Student addStudent(@RequestBody Student student) {
        return studentRepository.save(student);
    }

    // READ All
    @GetMapping
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    // READ by ID
    @GetMapping("/{id}")
    public Student getStudent(@PathVariable int id) {
        return studentRepository.findById(id).orElse(null);
    }

    // UPDATE
    @PutMapping("/{id}")
    public Student updateStudent(@RequestBody Student updatedStudent, @PathVariable int id) {
        Student student = studentRepository.findById(id).orElse(null);
        if (student != null) {
            student.setName(updatedStudent.getName());
            student.setEmail(updatedStudent.getEmail());
            return studentRepository.save(student);
        }
        return null;
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable int id) {
        studentRepository.deleteById(id);
        return "Deleted student with id " + id;
    }
}
