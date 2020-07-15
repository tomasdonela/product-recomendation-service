package com.interview.seb.entity.question;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Arrays;
import java.util.List;

public class QuestionWithYesNoOption implements Question{
    private final String subject;
    private final String question;
    private final List<AnswerOption> answerOptions = Arrays.asList(YesNoOption.values());

    @JsonCreator
    public QuestionWithYesNoOption(
            @JsonProperty("subject") String subject,
            @JsonProperty("question") String question) {
        this.subject = subject;
        this.question = question;
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
