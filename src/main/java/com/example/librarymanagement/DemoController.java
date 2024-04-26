package com.example.librarymanagement;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @GetMapping("/")
    public String welcomeMessage() {
        return "Welcome to the Library Management System!";
    }
}
