package com.aseemsavio.responsio.posts.model.requests;

public class DeleteQuestionRequest {

    private String userId;
    private String questionId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }
}
