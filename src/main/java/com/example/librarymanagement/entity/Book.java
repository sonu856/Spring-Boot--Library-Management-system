package com.example.librarymanagement.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@JsonIgnoreProperties({"rental"})
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @ManyToOne
    private Author author;

    private String isbn;
    private int publicationYear;
    private boolean available;

    @OneToOne(mappedBy = "book")
    private Rental rental;

    // Constructors, getters, and setters
}
