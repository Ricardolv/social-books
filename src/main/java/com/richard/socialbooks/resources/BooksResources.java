package com.richard.socialbooks.resources;

import com.richard.socialbooks.domain.Book;
import com.richard.socialbooks.repository.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BooksResources {

    @Autowired
    private BooksRepository booksRepository;

    @GetMapping
    public List<Book> list() {
        return booksRepository.findAll();
    }
}
