package com.karim.Book_network.book;

import jakarta.validation.constraints.NotBlank;

public record BookRequest(

        @NotBlank(message = "100")
        String tittle,

        @NotBlank(message = "101")
        String authorName,

        @NotBlank(message = "102")
        String isbn,

        @NotBlank(message = "103")
        String synopsis,

        boolean shearable
) {


}
