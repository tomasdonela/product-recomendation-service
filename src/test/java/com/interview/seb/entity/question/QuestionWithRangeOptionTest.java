package com.interview.seb.entity.question;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class QuestionWithRangeOptionTest {

    private final Question question = new QuestionWithRangeOption(
            "AGE",
            "What is your age ?",
            Arrays.asList(new RangeOption(0, 1), new RangeOption(1, 2)));

    @Test
    void shouldThrowExceptionWhenAnswerWasNotFoundInOptions(){
        assertThrows(IllegalArgumentException.class, () -> question.getAnswerOption("Not exists"));
    }
}