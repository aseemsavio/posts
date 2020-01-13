package com.aseemsavio.responsio.posts.exceptions;

import com.aseemsavio.responsio.posts.utils.ErrorCode;

public class DeletionException extends Exception {

    private final ErrorCode code;
    private final String errorMessage;


    public DeletionException(final ErrorCode code, final String errorMessage) {
        this.code = code;
        this.errorMessage = errorMessage;
    }

    public static String getExceptionName() {
        return "DeletionException";
    }
    
}
