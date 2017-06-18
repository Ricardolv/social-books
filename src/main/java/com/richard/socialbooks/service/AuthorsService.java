package com.richard.socialbooks.service;

import com.richard.socialbooks.domain.Author;
import com.richard.socialbooks.repository.AuthorsRepository;
import com.richard.socialbooks.service.exceptions.AuthorExistException;
import com.richard.socialbooks.service.exceptions.AuthorFoundException;
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

        if (null != author && null != author.getId()) {
            Author autorExist = authorsRepository.findOne(author.getId());

            if (null != autorExist) {
                throw new AuthorExistException("Autor ja existe!");
            }
        }

        return authorsRepository.save(author);
    }

    public Author search(Long id) {
        Author author = authorsRepository.findOne(id);

        if (null == author) {
            throw new AuthorFoundException("Author nao encontrado!");
        }

        return author;
    }
}
