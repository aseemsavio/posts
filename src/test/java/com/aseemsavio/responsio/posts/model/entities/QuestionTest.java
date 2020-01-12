package com.aseemsavio.responsio.posts.model.entities;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuestionTest {

    Question question;

    @BeforeEach
    void setUp() {
        question = new Question();
        question.setQuestionId("qid");
        question.setContent("aseem");
        question.setCreationTS(null);
        question.setUserId("uid");
    }

    @AfterEach
    void tearDown() {
        question = null;
    }

    @Test
    void getQuestionId() {
        assertEquals("qid", question.getQuestionId());
    }

    @Test
    void setQuestionId() {
        question.setQuestionId("gjh");
        assertEquals("gjh", question.getQuestionId());
    }

    @Test
    void getUserId() {
        assertEquals("uid", question.getUserId());
    }

    @Test
    void setUserId() {
        question.setUserId("hjk");
        assertEquals("hjk", question.getUserId());
    }

    @Test
    void getContent() {
        assertEquals("aseem", question.getContent());
    }

    @Test
    void setContent() {
        question.setContent("cont");
        assertEquals("cont", question.getContent());
    }

    @Test
    void getCreationTS() {
        assertNull(question.getCreationTS());
    }

    @Test
    void setCreationTS() {
        question.setCreationTS(null);
        assertNull(question.getCreationTS());
    }
}