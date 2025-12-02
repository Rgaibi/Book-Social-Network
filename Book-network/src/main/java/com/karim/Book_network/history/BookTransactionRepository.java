package com.karim.Book_network.history;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BookTransactionRepository extends JpaRepository<BookTransactionHistory, Integer> {

    @Query(value = """
        SELECT *
        FROM BookTransactionHistory 
        WHERE user_id = :userId
        """, nativeQuery = true)
    Page<BookTransactionHistory> findAllBorrowedBooks(Integer id, Pageable pageable);


    @Query(value = """
        SELECT h.*
        FROM book_transaction_history h
        JOIN book b ON h.book_id = b.id
        WHERE b.owner_id = :userId
            AND h.returned = true;
        """, nativeQuery = true)
    Page<BookTransactionHistory>findAllReturnedBooks (Integer id, Pageable pageable);
}
