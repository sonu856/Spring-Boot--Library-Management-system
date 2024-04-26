package com.example.librarymanagement.service;

import com.example.librarymanagement.entity.Book;
import com.example.librarymanagement.entity.Rental;
import com.example.librarymanagement.repository.BookRepository;
import com.example.librarymanagement.repository.RentalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class RentalService {
    @Autowired
    private RentalRepository rentalRepository;

    @Autowired
    private BookRepository bookRepository;

    public Rental createRental(Rental rentalRequest) {
        Book book = bookRepository.findById(rentalRequest.getBook().getId()).orElse(null);
        if (book != null && book.isAvailable()) {
            // Create a new rental record
            Rental rental = new Rental();
            rental.setBook(book);
            rental.setRenterName(rentalRequest.getRenterName());
            rental.setRentalDate(LocalDate.now());

            // Save the new rental record
            Rental savedRental = rentalRepository.save(rental);

            // Update book availability
            book.setRental(savedRental);
            book.setAvailable(false);
            bookRepository.save(book);

            return savedRental;
        }
        return null;
    }



    public List<Rental> getAllRentals() {
        return rentalRepository.findByReturnDateIsNull();
    }

    public List<Rental> getOverdueRentals() {
        int maxRentalDays = 14;
        LocalDate dueDate = LocalDate.now().minusDays(maxRentalDays);
        return rentalRepository.findByReturnDateIsNullAndRentalDateBefore(dueDate);
    }

    public Rental returnBook(Long rentalId) {
        Rental rental = rentalRepository.findById(rentalId).orElse(null);
        if (rental != null) {
            rental.setReturnDate(LocalDate.now());
            Book book = rental.getBook();
            book.setRental(null);
            book.setAvailable(true); // Set availability status to true
            bookRepository.save(book); // Save the updated Book entity
            rentalRepository.delete(rental);
            return rental;
        }
        return null;
    }
}