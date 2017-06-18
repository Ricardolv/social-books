package com.richard.socialbooks.repository;

import com.richard.socialbooks.domain.Comments;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentsRepository extends JpaRepository<Comments, Long> {

}
