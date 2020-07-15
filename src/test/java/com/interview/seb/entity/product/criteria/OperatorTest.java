package com.interview.seb.entity.product.criteria;

import com.interview.seb.entity.question.AnswerOption;
import com.interview.seb.entity.question.RangeOption;
import com.interview.seb.entity.question.YesNoOption;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class OperatorTest {
    private static final AnswerOption answerYesNo = YesNoOption.YES;
    private final AnswerOption answerRangeFull = new RangeOption(1, 2);
    private final AnswerOption answerRangeWithoutEnd = new RangeOption(1, null);

    @Test
    void operatorIsEqualShouldWorkWithYesNoOption(){
        testWithSequence(Operator.IS_EQUAL, answerYesNo,
                Map.of("YES", true,
                        "NO", false));
    }

    @Test
    void testOperatorIsMoreThenWithRangeOption(){
        Map<String, Boolean> inputAndExpectedResultSequence = Map.of(
                "0", true,
                "1", false,
                "2", false,
                "3", false);
        testWithSequence(Operator.IS_MORE_THEN, answerRangeFull, inputAndExpectedResultSequence);
        testWithSequence(Operator.IS_MORE_THEN, answerRangeWithoutEnd, inputAndExpectedResultSequence);
    }

    @Test
    void testOperatorIsMoreEqualThenWithRangeOption(){
        Map<String, Boolean> inputAndExpectedResultSequence = Map.of(
                "0", true,
                "1", true,
                "2", false,
                "3", false);
        testWithSequence(Operator.IS_MORE_EQUAL_THEN, answerRangeFull, inputAndExpectedResultSequence);
        testWithSequence(Operator.IS_MORE_EQUAL_THEN, answerRangeWithoutEnd, inputAndExpectedResultSequence);
    }

    @Test
    void testOperatorIsLessEqualThenWithRangeOption(){
        Map<String, Boolean> inputAndExpectedResultSequence = Map.of(
                "0", false,
                "1", false,
                "2", false,
                "3", true);
        testWithSequence(Operator.IS_LESS_THEN, answerRangeFull, inputAndExpectedResultSequence);
        inputAndExpectedResultSequence = Map.of(
                "0", false,
                "1", false,
                "2", false,
                "3", false);
        testWithSequence(Operator.IS_LESS_THEN, answerRangeWithoutEnd, inputAndExpectedResultSequence);
    }

    @Test
    void operatorIsEqualShouldReturnFalseWithRangeOption(){
        testWithSequence(Operator.IS_EQUAL, answerRangeFull,
                Map.of("", false));
    }

    @Test
    void operatorIsMoreThenShouldReturnFalseWithYesNoOption(){
        assertFalse(Operator.IS_MORE_THEN.execute(answerYesNo, ""));
    }

    @Test
    void operatorIsMoreEqualThenShouldReturnFalseWithYesNoOption(){
        assertFalse(Operator.IS_MORE_EQUAL_THEN.execute(answerYesNo, ""));
    }

    @Test
    void operatorIsLessThenShouldReturnFalseWithYesNoOption(){
        assertFalse(Operator.IS_LESS_THEN.execute(answerYesNo, ""));
    }

    private void testWithSequence(Operator operator, AnswerOption answer, Map<String, Boolean> sequence){
        sequence.forEach((key, value) -> assertEquals(value, operator.execute(answer, key)));
    }
}