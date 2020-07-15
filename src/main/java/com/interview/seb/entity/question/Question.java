package com.interview.seb.entity.question;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.util.List;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME , property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = QuestionWithRangeOption.class, name = "RANGE"),
        @JsonSubTypes.Type(value = QuestionWithYesNoOption.class, name = "YES_NO")
})
public interface Question {
    String getSubject();
    String getQuestion();
    List<AnswerOption> getAnswerOptions();
    AnswerOption getAnswerOption(String customerAnswer);
}
