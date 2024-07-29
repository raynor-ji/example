package com.liooos.example.test.mocks.inject;

import org.springframework.stereotype.Service;

@Service
public class DatabaseService {
    public Book findById(String id) {
        // querying a Database and getting a book
        return new Book("id","Name", "Author");
    }
}
