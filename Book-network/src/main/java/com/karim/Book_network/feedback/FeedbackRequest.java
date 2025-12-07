package com.karim.Book_network.feedback;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public record FeedbackRequest(
        @Positive(message = "200")
        @Min(value = 0, message = "201")
        @Max(value = 5, message = "202")
        Double note,
        
        @NotBlank(message = "203")
        String comment,

        @NotBlank(message = "203")
        Integer bookId
) {
}
