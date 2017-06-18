package com.richard.socialbooks.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
public class BooksResources {

    @GetMapping
    public String list() {
        return "Rest aplicado, Git";
    }
}
