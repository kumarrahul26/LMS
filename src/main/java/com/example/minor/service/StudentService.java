package com.example.minor.service;


import com.example.minor.models.OperationType;
import com.example.minor.models.Student;
import com.example.minor.models.StudentFilterType;
import com.example.minor.repository.StudentRepository;
import com.example.minor.request.CreateStudentRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.fasterxml.jackson.databind.jsonFormatVisitors.JsonValueFormat.EMAIL;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> findStudent(StudentFilterType studentFilterType, String value, OperationType operationType) {
        switch (operationType) {
            case EQUALS:
                switch (studentFilterType) {
                    case EMAIL:
                        return studentRepository.findByEmail(value);
                    case CONTACT:
                        return studentRepository.findByContact(value);

                }
            default:
                return new ArrayList<>();

        }
    }

    public Student create(CreateStudentRequest createStudentRequest) {

        List<Student> students=findStudent(StudentFilterType.CONTACT,createStudentRequest.getContact(),OperationType.EQUALS);

        if(students == null || students.isEmpty()){
            Student student=createStudentRequest.to();
            return studentRepository.save(student);
        }return students.get(0);
        }


}
