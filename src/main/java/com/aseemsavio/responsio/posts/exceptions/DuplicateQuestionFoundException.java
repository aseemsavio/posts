package com.aseemsavio.responsio.posts.exceptions;

import com.aseemsavio.responsio.posts.utils.ErrorCode;

public class DuplicateQuestionFoundException extends Exception {

    private final ErrorCode code;
    private final String errorMessage;


    public DuplicateQuestionFoundException(final ErrorCode code, final String errorMessage) {
        this.code = code;
        this.errorMessage = errorMessage;
    }

}
