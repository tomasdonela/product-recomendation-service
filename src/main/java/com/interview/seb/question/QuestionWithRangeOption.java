package com.interview.seb.question;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
    public Optional<AnswerOption> getAnswerOption(String answerName) {
        return answerOptions
                .stream()
                .filter(option -> answerName.equals(option.getName()))
                .findFirst();
    }
}
