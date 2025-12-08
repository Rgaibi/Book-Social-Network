package com.karim.Book_network.feedback;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface FeedbackRepository extends JpaRepository<Feedback, Integer> {

    @Query(value = """
        SELECT *
        FROM Feedback
        WHERE book_id = :bookId
        """, nativeQuery = true)
    Page<Feedback> findAllByBookId(Integer bookId, Pageable pageable);
}
