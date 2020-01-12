package com.aseemsavio.responsio.posts.model.responses;

import com.aseemsavio.responsio.posts.model.entities.Question;

import java.util.List;

public class Questions {

    List<Question> questions;

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }
}
