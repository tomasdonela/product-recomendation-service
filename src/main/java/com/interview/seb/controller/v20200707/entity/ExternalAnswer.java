package com.interview.seb.controller.v20200707.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ExternalAnswer {
    private final String subject;
    private final String Answer;

    @JsonCreator
    public ExternalAnswer(@JsonProperty("subject") String subject, @JsonProperty("answer") String answer) {
        this.subject = subject;
        Answer = answer;
    }

    public String getSubject() {
        return subject;
    }

    public String getAnswer() {
        return Answer;
    }
}
