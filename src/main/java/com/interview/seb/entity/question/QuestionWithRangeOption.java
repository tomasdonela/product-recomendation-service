package com.interview.seb.entity.question;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class QuestionWithRangeOption implements Question{
    private final String subject;
    private final String question;
    private final List<AnswerOption> answerOptions;

    @JsonCreator
    public QuestionWithRangeOption(
            @JsonProperty("subject") String subject,
            @JsonProperty("question") String question,
            @JsonProperty("answerOptions") List<RangeOption> answerOptions) {
        this.subject = subject;
        this.question = question;
        this.answerOptions = new ArrayList<>(answerOptions);
    }

    @Override
    public String getSubject() {
        return this.subject;
    }

    @Override
    public String getQuestion() {
        return this.question;
    }

    @Override
    public List<AnswerOption> getAnswerOptions() {
        return this.answerOptions;
    }

    @Override
    public AnswerOption getAnswerOption(String customerAnswer) {
        return this.answerOptions
                .stream()
                .filter(option -> option.getName().equals(customerAnswer))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(
                        String.format("Option %s could not be found for subject %s.", customerAnswer, this.subject)));
    }
}
