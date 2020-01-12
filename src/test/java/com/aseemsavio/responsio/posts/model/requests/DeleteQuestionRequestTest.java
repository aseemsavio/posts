package com.aseemsavio.responsio.posts.model.requests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeleteQuestionRequestTest {

    DeleteQuestionRequest deleteQuestionRequest;

    @BeforeEach
    void setUp() {
        deleteQuestionRequest = new DeleteQuestionRequest();
        deleteQuestionRequest.setUserId("kjhakjhfakjfhkjfhk");
        deleteQuestionRequest.setQuestionId("ajhakjfhakjshakjshfakjfhk");
    }

    @AfterEach
    void tearDown() {
        deleteQuestionRequest = null;
    }

    @Test
    void getUserId() {
        assertEquals("kjhakjhfakjfhkjfhk", deleteQuestionRequest.getUserId());
    }

    @Test
    void setUserId() {
        deleteQuestionRequest.setUserId("kjhkjh");
        assertEquals("kjhkjh", deleteQuestionRequest.getUserId());
    }

    @Test
    void getQuestionId() {
        assertEquals("ajhakjfhakjshakjshfakjfhk", deleteQuestionRequest.getQuestionId());
    }

    @Test
    void setQuestionId() {
        deleteQuestionRequest.setQuestionId("jasshkjhkjhk");
        assertEquals("jasshkjhkjhk", deleteQuestionRequest.getQuestionId());
    }
}