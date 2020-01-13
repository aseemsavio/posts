package com.aseemsavio.responsio.posts.controllers;

import com.aseemsavio.responsio.posts.exceptions.DuplicateQuestionFoundException;
import com.aseemsavio.responsio.posts.model.responses.ResponsioResponseEntity;
import com.aseemsavio.responsio.posts.utils.factories.ResponseioResponseFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import static com.aseemsavio.responsio.posts.utils.ErrorMessage.DUPLICATE_QUESTION_FOUND_EXCEPTION_MSG;
import static com.aseemsavio.responsio.posts.utils.PostRESToperation.QUESTION_CREATION;
import static com.aseemsavio.responsio.posts.utils.Status.ERROR;

@ControllerAdvice
public class ResponsioExceptionHandler {

    @ExceptionHandler(value = DuplicateQuestionFoundException.class)
    public ResponseEntity<ResponsioResponseEntity<String>> handleDuplicateQuestionException() {
        ResponseioResponseFactory<String> responseFactory = new ResponseioResponseFactory<>();
        StringBuilder stringBuilder = new StringBuilder();
        String errorMessage = stringBuilder.append(DuplicateQuestionFoundException.getExceptionName()).append(": ").append(DUPLICATE_QUESTION_FOUND_EXCEPTION_MSG).toString();
        ResponsioResponseEntity responseEntity = responseFactory.build(errorMessage, QUESTION_CREATION, ERROR);
        return new ResponseEntity(responseEntity, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
