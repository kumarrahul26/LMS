package com.example.minor.repository;

import com.example.minor.models.Book;
import com.example.minor.models.BookType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book,Integer>{

    List<Book> findByBookNo(String bookNo);

    List<Book> findByAuthor_Name(String authorName);

    List<Book> findByCost(Integer cost);

    List<Book> findByCostLessThan(Integer cost);

    List<Book> findByCostGreaterThan(Integer cost);


    List<Book> findByType(BookType type);

}