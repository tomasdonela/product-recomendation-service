package com.interview.seb.entity.question;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class QuestionWithYesNoOptionTest {
    private final Question question = new QuestionWithYesNoOption(
            "STUDENT",
            "Is your status student ?");

    @Test
    void shouldThrowExceptionWhenAnswerWasNotFoundInOptions() {
        assertThrows(IllegalArgumentException.class, () -> question.getAnswerOption("Not exists"));
    }
}