package com.example.minor.controller;

import com.example.minor.models.*;
import com.example.minor.request.CreateStudentRequest;
import com.example.minor.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping("/create")
    public Student create(@RequestBody CreateStudentRequest createStudentRequest){
        return studentService.create(createStudentRequest);
    }

    @GetMapping("/find")
    public List<Student> findStudent(@RequestParam("filter") StudentFilterType StudentFilterType, @RequestParam("value") String value,
                                     @RequestParam("operation") OperationType operationType){
        return studentService.findStudent(StudentFilterType,value,operationType);

    }
}
