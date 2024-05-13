package com.example.minor.request;


import com.example.minor.models.Student;
import com.example.minor.models.StudentType;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class CreateStudentRequest {
    private String name;

    private String address;

    private String contact;
    private String email;

    public Student to() {
        return Student.builder().
                name(this.name).
                email(this.email).
                contact(this.contact).
                studentType(StudentType.ACTIVE).
                address(this.address).build();

    }
}
