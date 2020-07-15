package com.interview.seb.entity.question;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class RangeOptionTest {
    private static final int RANGE_START = 1;
    private static final int RANGE_END = 2;
    private final AnswerOption fullOption = new RangeOption(RANGE_START, RANGE_END);
    private final AnswerOption optionWithoutRangeEnd = new RangeOption(RANGE_START, null);

    @Test
    void shouldReturnNames() {
        Assert.assertEquals(RANGE_START + "-" + RANGE_END, fullOption.getName());
        Assert.assertEquals(RANGE_START + "+", optionWithoutRangeEnd.getName());
    }
}
