package com.aseemsavio.responsio.posts.utils.factories;

import com.aseemsavio.responsio.posts.model.responses.ResponsioResponseEntity;
import com.aseemsavio.responsio.posts.utils.PostRESToperation;
import org.springframework.http.HttpStatus;

import static com.aseemsavio.responsio.posts.utils.Status.SUCCESS;

public class ResponseioResponseFactory<T> {

    public ResponsioResponseEntity<T> build(T object, PostRESToperation postRESToperation, String status) {
        if (status.equals(SUCCESS)) {
            return new ResponsioResponseEntity<>(HttpStatus.CREATED, status, object.getClass().getName(), object);
        }
        return new ResponsioResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR, status, object.getClass().getName(), object);
    }

}
