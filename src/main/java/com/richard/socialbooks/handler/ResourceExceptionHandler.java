package com.richard.socialbooks.handler;

import com.richard.socialbooks.domain.DetailsError;
import com.richard.socialbooks.service.exceptions.AuthorExistException;
import com.richard.socialbooks.service.exceptions.AuthorFoundException;
import com.richard.socialbooks.service.exceptions.BookFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(BookFoundException.class)
    public ResponseEntity<DetailsError> handlerBookFoundException(BookFoundException e, HttpServletRequest request) {

        DetailsError error = new DetailsError();
        error.setStatus(404l);
        error.setTitle("O livro nao pode ser encontrado");
        error.setMessageDev("http://errors.socialbooks.com/404");
        error.setTimesTamp(System.currentTimeMillis());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(AuthorExistException.class)
    public ResponseEntity<DetailsError> handlerAuthorExistException(AuthorExistException e, HttpServletRequest request) {

        DetailsError error = new DetailsError();
        error.setStatus(409l);
        error.setTitle("O Author ja existente");
        error.setMessageDev("http://errors.socialbooks.com/409");
        error.setTimesTamp(System.currentTimeMillis());

        return ResponseEntity.status(HttpStatus.CONFLICT).body(error);
    }

    @ExceptionHandler(AuthorFoundException.class)
    public ResponseEntity<DetailsError> handlerAuthorFoundException(AuthorFoundException e, HttpServletRequest request) {

        DetailsError error = new DetailsError();
        error.setStatus(404l);
        error.setTitle("O Autor nao pode ser encontrado");
        error.setMessageDev("http://errors.socialbooks.com/404");
        error.setTimesTamp(System.currentTimeMillis());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<DetailsError> handlerDataIntegrityViolationException(DataIntegrityViolationException e, HttpServletRequest request) {

        DetailsError error = new DetailsError();
        error.setStatus(400l);
        error.setTitle("Requisicao invalida");
        error.setMessageDev("http://errors.socialbooks.com/400");
        error.setTimesTamp(System.currentTimeMillis());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

}
