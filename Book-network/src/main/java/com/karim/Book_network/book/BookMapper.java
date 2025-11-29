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

    public BookResponse toBookResponse(Book book) {
        return BookResponse.builder()
                .id(book.getId())
                .title(book.getTittle())
                .authorName(book.getAuthorName())
                .isbn(book.getIsbn())
                .synopsis(book.getSynopsis())
                .rate(book.getRate())
                .archived(book.isArchived())
                .owner(book.getOwner().fullName())
                .build();
    }
}
