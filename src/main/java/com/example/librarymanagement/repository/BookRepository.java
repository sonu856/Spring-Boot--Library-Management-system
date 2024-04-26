package com.example.librarymanagement.repository;


import com.example.librarymanagement.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByAuthorId(Long authorId);
    List<Book> findByRentalIsNull();
    List<Book> findByRentalIsNotNull();
    List<Book> findByAvailableTrue();
}
