package com.aseemsavio.responsio.posts.model.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(value = "questions")
public class Question {

    @Id
    private String questionId;
    private String userId;
    private String content;
    private LocalDateTime creationTS;

    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getCreationTS() {
        return creationTS;
    }

    public void setCreationTS(LocalDateTime creationTS) {
        this.creationTS = creationTS;
    }

    @Override
    public String toString() {
        return "Question{" +
                "questionId='" + questionId + '\'' +
                ", userId='" + userId + '\'' +
                ", content='" + content + '\'' +
                ", creationTS=" + creationTS +
                '}';
    }
}
