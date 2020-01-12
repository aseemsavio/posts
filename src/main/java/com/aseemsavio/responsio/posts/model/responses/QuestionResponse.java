package com.aseemsavio.responsio.posts.model.responses;

public class QuestionResponse {

    private String id;
    private String content;
    private String message;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public QuestionResponse(String id, String content, String message) {
        this.id = id;
        this.content = content;
        this.message = message;
    }
}
