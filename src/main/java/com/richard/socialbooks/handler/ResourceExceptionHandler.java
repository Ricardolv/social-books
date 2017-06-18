package com.richard.socialbooks.handler;

import com.richard.socialbooks.domain.DetailsError;
import com.richard.socialbooks.service.exceptions.BookFoundException;
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

}
