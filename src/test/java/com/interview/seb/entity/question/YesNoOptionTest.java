package com.interview.seb.entity.question;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static com.interview.seb.entity.question.YesNoOption.NO;
import static com.interview.seb.entity.question.YesNoOption.YES;

class YesNoOptionTest {
    private static final AnswerOption optionYes = YES;
    private static final AnswerOption optionNo = NO;

    @Test
    void shouldReturnNames() {
        Assert.assertEquals("Yes", optionYes.getName());
        Assert.assertEquals("No", optionNo.getName());
    }
}