package com.karim.Book_network.book;

import org.springframework.stereotype.Service;

@Service
public class BookMapper {

    public Book toBook (BookRequest request) {
        return Book.builder()
                .tittle(request.tittle())
                .authorName(request.authorName())
                .synopsis(request.synopsis())
                .archived(false)
                .shearable(request.shearable())
                .build();
    }
}
