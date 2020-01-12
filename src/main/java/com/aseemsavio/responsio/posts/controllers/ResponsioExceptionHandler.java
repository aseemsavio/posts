package com.aseemsavio.responsio.posts.controllers;

import com.aseemsavio.responsio.posts.exceptions.DuplicateQuestionFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import static com.aseemsavio.responsio.posts.utils.ErrorMessage.DUPLICATE_QUESTION_FOUND_EXCEPTION_MSG;


@ControllerAdvice
public class ResponsioExceptionHandler {

    @ExceptionHandler(value = DuplicateQuestionFoundException.class)
    public ResponseEntity<Object> handleDuplicateQuestionException() {
        return new ResponseEntity<>(DUPLICATE_QUESTION_FOUND_EXCEPTION_MSG, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
