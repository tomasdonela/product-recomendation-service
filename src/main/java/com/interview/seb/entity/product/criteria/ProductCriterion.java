package com.interview.seb.entity.product.criteria;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.interview.seb.entity.question.AnswerOption;

import java.util.Map;
import java.util.Optional;

public class ProductCriterion {

    private final String subject;
    private final Operator operator;
    private final String argument;

    @JsonCreator()
    private ProductCriterion(
            @JsonProperty("subject") String subject,
            @JsonProperty("operator") Operator operator,
            @JsonProperty("argument") String argument) {
        this.subject = subject;
        this.operator = operator;
        this.argument = argument;
    }

    public boolean isMatching(Map<String, Optional<AnswerOption>> customerAnswers) {
        Optional<AnswerOption> customerAnswerBySubject = customerAnswers.get(subject);
        return customerAnswerBySubject.isPresent() && operator.execute(customerAnswerBySubject.get(), argument);
    }
}