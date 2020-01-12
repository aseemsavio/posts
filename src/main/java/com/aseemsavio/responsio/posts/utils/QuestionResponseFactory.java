package com.aseemsavio.responsio.posts.utils;

import com.aseemsavio.responsio.posts.model.entities.Question;
import com.aseemsavio.responsio.posts.model.responses.QuestionResponse;

import static com.aseemsavio.responsio.posts.utils.Status.SUCCESS;

public class QuestionResponseFactory {

    public QuestionResponseFactory() {

    }

    public static QuestionResponse build(Question question, PostRESToperation postRESToperation, Status status) {

        if(status.equals(SUCCESS)) {
            return new QuestionResponse(
                    question.getQuestionId(),
                    question.getContent(),
                    "");
        }
        return null;
    }



}
