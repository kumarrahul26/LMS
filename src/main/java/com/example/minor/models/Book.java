package com.example.minor.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@ToString
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 30)
    private String name;

    private int cost;
    @ManyToOne
    @JoinColumn
    @JsonIgnoreProperties("bookList")
    @JsonIgnore
    private Author author;

    private String bookNo;
    @Enumerated(value = EnumType.STRING)
    private BookType type;
    @JoinColumn
    @ManyToOne
    @JsonIgnoreProperties("bookList")
    private Student student;



}
