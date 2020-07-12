package com.interview.seb.product.condition;

import com.interview.seb.question.AnswerOption;
import com.interview.seb.question.RangeOption;
import java.util.function.BiPredicate;

public enum Operator {
    IS_MORE_THEN(AnswerOption::isMoreThen),
    IS_MORE_EQUAL_THEN(AnswerOption::isMoreEqualThen),
    IS_LESS_THEN(AnswerOption::isLessThen),
    IS_EQUAL(AnswerOption::isEqual);

    private final BiPredicate<AnswerOption, String> predicate;

    Operator(BiPredicate<AnswerOption, String> predicate) {
        this.predicate = predicate;
    }

    public boolean execute(AnswerOption answer, String argument){
        return predicate.test(answer, argument);
    }
}
