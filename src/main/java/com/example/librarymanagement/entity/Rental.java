package com.example.librarymanagement.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Entity
@Data
public class Rental {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "book_id", referencedColumnName = "id")
    private Book book;

    private String renterName;
    private LocalDate rentalDate;
    private LocalDate returnDate;

    // Constructors, getters, and setters
}