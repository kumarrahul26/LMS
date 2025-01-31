package com.example.minor.repository;

import com.example.minor.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student,Integer> {

    List<Student> findByEmail(String email);

    List<Student> findByContact(String contact);
}
