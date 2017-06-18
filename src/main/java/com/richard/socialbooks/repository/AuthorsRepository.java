package com.richard.socialbooks.repository;

import com.richard.socialbooks.domain.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorsRepository extends JpaRepository<Author, Long> {

}
