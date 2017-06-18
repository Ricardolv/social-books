package com.richard.socialbooks.service;

import com.richard.socialbooks.domain.Book;
import com.richard.socialbooks.repository.BooksRepository;
import com.richard.socialbooks.service.exceptions.BookFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BooksService {

    @Autowired
    private BooksRepository booksRepository;

    public Book save(Book book) {
        return booksRepository.save(book);
    }

    public List<Book> findAll() {
        return  booksRepository.findAll();
    }

    public Book search(Long id) {

        Book book = booksRepository.findOne(id);

        if (null == book) {
            throw new BookFoundException("O livro nao pode ser encontrado");
        }

        return book;
    }

    public void delete(Long id) {

        try {
            booksRepository.delete(id);

        } catch (EmptyResultDataAccessException e) {
            throw new BookFoundException("O livro nao pode ser encontrado");
        }
    }

    public void update(Book book) {
        existBook(book);
        booksRepository.save(book);
    }

    private void existBook(Book book) {
        search(book.getId());
    }
}