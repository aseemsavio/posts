package com.aseemsavio.responsio.posts.model.responses;

import org.springframework.http.HttpStatus;

public class ResponsioResponseEntity<T> {

    private HttpStatus httpStatus;
    private String successState;
    private String objectType;
    private T content;

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    public String getSuccessState() {
        return successState;
    }

    public void setSuccessState(String successState) {
        this.successState = successState;
    }

    public String getObjectType() {
        return objectType;
    }

    public void setObjectType(String objectType) {
        this.objectType = objectType;
    }

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }

    public ResponsioResponseEntity(HttpStatus httpStatus, String successState, String objectType, T content) {
        this.httpStatus = httpStatus;
        this.successState = successState;
        this.objectType = objectType;
        this.content = content;
    }

    @Override
    public String toString() {
        return "ResponsioResponseEntity{" +
                "httpStatus=" + httpStatus +
                ", successState='" + successState + '\'' +
                ", objectType='" + objectType + '\'' +
                ", content=" + content +
                '}';
    }
}
