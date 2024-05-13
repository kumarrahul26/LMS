package com.example.minor.request;

import com.example.minor.models.Author;
import com.example.minor.models.Book;
import com.example.minor.models.BookType;

import lombok.*;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class CreateBookRequest {

    private String bookName;

    private int cost;

    private String bookNo;

    private BookType type;

    private String authorName;

    private String authorEmail;


    public Book to() {
        Author authorData= Author.builder().
                name(this.authorName).
                email(this.authorEmail).
                build();

        return Book.builder().bookNo(this.bookNo).
                name(this.bookName).
                cost(this.cost).
                type(this.type).
                author(authorData).
                build();
    }
}
