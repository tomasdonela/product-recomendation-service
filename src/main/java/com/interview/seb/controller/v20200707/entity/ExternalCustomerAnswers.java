package com.interview.seb.controller.v20200707.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ExternalCustomerAnswers {
    private final List<ExternalAnswer> answers;

    @JsonCreator
    public ExternalCustomerAnswers(@JsonProperty("answers") List<ExternalAnswer> answers) {
        this.answers = answers;
    }

    public List<ExternalAnswer> getAnswers() {
        return answers;
    }

    public Map<String, String> toInternal(){
        return answers
                .stream()
                .collect(Collectors.toMap(ExternalAnswer::getSubject, ExternalAnswer::getAnswer));
    }
}
