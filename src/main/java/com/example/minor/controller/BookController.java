package com.example.minor.controller;

import com.example.minor.models.Book;
import com.example.minor.models.BookFilterType;
import com.example.minor.models.OperationType;
import com.example.minor.request.CreateBookRequest;
import com.example.minor.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping("/create")
    public void create(@RequestBody CreateBookRequest createBookRequest){
        bookService.create(createBookRequest);
    }

    @GetMapping("/find")
    public List<Book> findBooks(@RequestParam("filter") BookFilterType bookFilterType, @RequestParam("value") String value,
                                @RequestParam("operation") OperationType operationType){
        return bookService.findBooks(bookFilterType,value,operationType);

    }
}
