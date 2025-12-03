package com.karim.Book_network.history;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface BookTransactionRepository extends JpaRepository<BookTransactionHistory, Integer> {

    @Query(value = """
        SELECT *
        FROM book_transaction_history 
        WHERE user_id = :userId
        """, nativeQuery = true)
    Page<BookTransactionHistory> findAllBorrowedBooks(@Param("userId") Integer id, Pageable pageable);


    @Query(value = """
        SELECT h.*
        FROM book_transaction_history h
        JOIN book b ON h.book_id = b.id
        WHERE b.owner_id = :userId
            AND h.returned = true;
        """, nativeQuery = true)
    Page<BookTransactionHistory>findAllReturnedBooks (@Param("userId") Integer id, Pageable pageable);

    @Query(value = """
        SELECT 
        COUNT(*) > 0 isBorrowed
        FROM book_transaction_history
        WHERE user_id = :userId
            AND book_id = :bookId
            AND returnApproved = false;
        """, nativeQuery = true)
    boolean isAlreadyBorrowed(@Param("bookId")Integer bookId, @Param("userId") Integer userId);

    @Query(value = """
        SELECT *
        FROM book_transaction_history
        WHERE user_id = :userId
            AND book_id = :bookId
            AND returned = false;
            AND returnApproved = false;
        """, nativeQuery = true)
    Optional<BookTransactionHistory> findIfUserBorrowedThisBook(@Param("bookId")Integer bookId, @Param("userId")Integer userId);

    @Query(value = """
        SELECT h.*
        FROM book_transaction_history h
        JOIN book b ON h.book_id = b.id
        WHERE owner_id = :userId
            AND book_id = :bookId
            AND returned = true;
            AND returnApproved = false;
        """, nativeQuery = true)
    Optional<BookTransactionHistory> findIfUserIsOwnerOfBorrowedBook(Integer bookId, Integer userId);
}
