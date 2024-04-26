package com.example.librarymanagement.repository;

import com.example.librarymanagement.entity.Rental;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface RentalRepository extends JpaRepository<Rental, Long> {
    List<Rental> findByReturnDateIsNullAndRentalDateBefore(LocalDate dueDate);

    List<Rental> findByReturnDateIsNull();
}

