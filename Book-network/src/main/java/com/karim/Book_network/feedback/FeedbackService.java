package com.karim.Book_network.feedback;

import com.karim.Book_network.book.Book;
import com.karim.Book_network.book.BookRepository;
import com.karim.Book_network.exception.OperationNotPermittedException;
import com.karim.Book_network.user.User;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Objects;
@Service
@RequiredArgsConstructor
public class FeedbackService {

    private final BookRepository bookRepository;
    private final FeedbackMapper feedbackMapper;
    private final FeedbackRepository feedbackRepository;


    public Integer save(FeedbackRequest request, Authentication connectedUser) {

        Book book = bookRepository.findById(request.bookId())
                .orElseThrow(() -> new EntityNotFoundException("No book found with the id : " + request.bookId()));
        if(book.isArchived() || !book.isShearable()) {
            throw new OperationNotPermittedException("You cannot give a feedback for an archived or not shareable book");
        }
        User user = (User) connectedUser.getPrincipal();
        if(!Objects.equals(book.getOwner().getId(), user.getId())) {
            throw new OperationNotPermittedException("You cannot give a feedback to yourn own book");
        }
        Feedback feedback = feedbackMapper.toFeedback(request);
        return feedbackRepository.save(feedback).getId();
    }
}
