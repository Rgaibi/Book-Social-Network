package com.karim.Book_network.book;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer>, JpaSpecificationExecutor<Book> {

    @Query(value = """
        SELECT *
        FROM book
        WHERE archived = false
        AND shareable = true
        AND owner_id != :userId
        """, nativeQuery = true)
    Page<Book> findAllDisplayableBooks(Pageable pageable, @Param("userId") Integer id);
}
