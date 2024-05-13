package com.example.minor.service;

import com.example.minor.models.*;
import com.example.minor.repository.AuthorRepository;
import com.example.minor.repository.BookRepository;
import com.example.minor.request.CreateBookRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;


    public void create(CreateBookRequest createBookRequest) {
        Book book=createBookRequest.to();
       Author authorFromDB = authorRepository.getAuthorWithEmailAddressWithoutNative(book.getAuthor().getEmail());
        if(authorFromDB == null){
            authorFromDB=authorRepository.save(book.getAuthor());
        }

        bookRepository.save(book);
    }

    public Book createUpdate(Book book){
       return bookRepository.save(book);
    }
    public List<Book> findBooks(BookFilterType bookFilterType, String value, OperationType operationType) {
        switch(operationType){
            case EQUALS:
                switch (bookFilterType){
                    case BOOK_NO:
                        return bookRepository.findByBookNo(value);
                    case AUTHOR_NAME:
                        return bookRepository.findByAuthor_Name(value);
                    case COST:
                        return bookRepository.findByCost(Integer.valueOf(value));
                    case BOOKTYPE:
                        return bookRepository.findByType(BookType.valueOf(value));
                }

            case LESS_THAN:
                switch (bookFilterType){
                    case COST:
                        return bookRepository.findByCostLessThan(Integer.valueOf(value));
                }
            case GREATER_THAN:
                switch (bookFilterType){
                    case COST:
                        return bookRepository.findByCostGreaterThan(Integer.valueOf(value));
                }
            default:
                return new ArrayList<>();
        }
    }
}
