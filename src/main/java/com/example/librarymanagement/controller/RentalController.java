package com.example.librarymanagement.controller;

import com.example.librarymanagement.entity.Rental;
import com.example.librarymanagement.service.RentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rentals")
public class RentalController {
    @Autowired
    private RentalService rentalService;

    @PostMapping
    public ResponseEntity<Rental> createRental(@RequestBody Rental rental) {
        Rental createdRental = rentalService.createRental(rental);
        return createdRental != null ? ResponseEntity.status(HttpStatus.CREATED).body(createdRental) : ResponseEntity.badRequest().build();
    }

    @GetMapping
    public ResponseEntity<List<Rental>> getAllRentals() {
        List<Rental> rentals = rentalService.getAllRentals();
        return ResponseEntity.ok(rentals);
    }

    @GetMapping("/overdue")
    public ResponseEntity<List<Rental>> getOverdueRentals() {
        List<Rental> overdueRentals = rentalService.getOverdueRentals();
        return ResponseEntity.ok(overdueRentals);
    }

    @PutMapping("/{rentalId}/return")
    public ResponseEntity<Rental> returnBook(@PathVariable Long rentalId) {
        Rental returnedRental = rentalService.returnBook(rentalId);
        return returnedRental != null ? ResponseEntity.ok(returnedRental) : ResponseEntity.notFound().build();
    }
}