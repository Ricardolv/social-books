package com.richard.socialbooks.service;

import com.richard.socialbooks.domain.Author;
import com.richard.socialbooks.repository.AuthorsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorsService {

    @Autowired
    private AuthorsRepository authorsRepository;

    public List<Author> list() {
        return authorsRepository.findAll();
    }

    public Author save(Author author) {
        return authorsRepository.save(author);
    }
}
