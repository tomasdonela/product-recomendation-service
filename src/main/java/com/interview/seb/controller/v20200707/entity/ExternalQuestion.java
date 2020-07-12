package com.interview.seb.controller.v20200707.entity;

import com.interview.seb.question.AnswerOption;
import com.interview.seb.question.Question;
import io.swagger.annotations.ApiModel;

import java.util.List;
import java.util.stream.Collectors;

@ApiModel("v20200707.ExternalQuestionMeta")
public class ExternalQuestion {
    private final String question;
    private final String subject;
    private final List<String> options;

    public ExternalQuestion(String question, String subject, List<String> options) {
        this.question = question;
        this.subject = subject;
        this.options = options;
    }

    public String getSubject() {
        return subject;
    }

    public String getQuestion() {
        return question;
    }

    public List<String> getOptions() {
        return options;
    }

    public static ExternalQuestion valueOf(Question question){
        return new ExternalQuestion(
                question.getQuestion(), question.getSubject(),
                question.getAnswerOptions()
                        .stream()
                        .map(AnswerOption::getName)
                        .collect(Collectors.toList()));
    }
}
