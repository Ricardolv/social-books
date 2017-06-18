package com.richard.socialbooks.repository;

import com.richard.socialbooks.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BooksRepository extends JpaRepository<Book, Long> {

}
