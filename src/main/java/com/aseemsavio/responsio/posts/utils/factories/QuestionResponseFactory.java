package com.aseemsavio.responsio.posts.utils.factories;

import com.aseemsavio.responsio.posts.model.entities.Question;
import com.aseemsavio.responsio.posts.model.responses.QuestionResponse;
import com.aseemsavio.responsio.posts.utils.PostRESToperation;

import static com.aseemsavio.responsio.posts.utils.PostRESToperation.*;
import static com.aseemsavio.responsio.posts.utils.PostsConstants.*;
import static com.aseemsavio.responsio.posts.utils.Status.FAILURE;
import static com.aseemsavio.responsio.posts.utils.Status.SUCCESS;

public class QuestionResponseFactory {

    public static QuestionResponse build(Question question, PostRESToperation postRESToperation, String status) {
        QuestionResponseFactory factory = new QuestionResponseFactory();
        return new QuestionResponse(
                question.getQuestionId(),
                question.getContent(),
                factory.getMessageForOperationWithStatus(postRESToperation, status));
    }

    private String getMessageForOperationWithStatus(PostRESToperation operation, String status) {

        if (operation == QUESTION_CREATION && status.equals(SUCCESS))
            return QUESTION_CREATION_SUCCESS_MSG;
        else if (operation == QUESTION_CREATION && status.equals(FAILURE))
            return QUESTION_CREATION_FAILURE_MSG;
        else if (operation == QUESTION_DELETION && status.equals(SUCCESS))
            return QUESTION_DELETE_SUCCESS_MSG;
        else if (operation == QUESTION_DELETION && status.equals(FAILURE))
            return QUESTION_DELETE_FAILURE_MSG;
        else if (operation == QUESTION_SEARCH_BY_ID && status.equals(SUCCESS))
            return QUESTION_SEARCH_SUCCESS_MSG;
        else if (operation == QUESTION_SEARCH_BY_ID && status.equals(FAILURE))
            return QUESTION_SEARCH_FAILED_MSG;
        else if (operation == QUESTION_SEARCH_MULTIPLE && status.equals(SUCCESS))
            return QUESTIONS_SEARCH_SUCCESS_MSG;
        else if (operation == QUESTION_SEARCH_MULTIPLE && status.equals(FAILURE))
            return QUESTIONS_SEARCH_FAILED_MSG;
        else if (operation == QUESTION_UPDATE && status.equals(SUCCESS))
            return QUESTION_UPDATE_SUCCESS_MSG;
        else if (operation == QUESTION_UPDATE && status.equals(FAILURE))
            return QUESTION_UPDATE_FAILURE_MSG;

        return ERROR;
    }


}
