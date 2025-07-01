package com.example;

import com.example.model.Student;
import com.example.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudentbootprojApplication implements CommandLineRunner {

    @Autowired
    private StudentRepository studentRepository;

    public static void main(String[] args) {
        SpringApplication.run(StudentbootprojApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Student s1 = new Student("Radha", "radha@gmail.com");
        Student s2 = new Student("Krishna", "krishna@gmail.com");

        studentRepository.save(s1);
        studentRepository.save(s2);

        System.out.println("✅ Students saved to DB at startup.");
    }
}
