package com.richard.socialbooks.resources;

import com.richard.socialbooks.domain.Book;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BooksResources {

    @GetMapping
    public List<Book> list() {

        Book b1 = new Book("Rest aplicado");
        Book b2 = new Book("Git");


        return Arrays.asList(b1, b2);
    }
}
