package com.interview.seb.product.condition;

import com.interview.seb.entity.RangeItem;
import java.util.function.BiPredicate;

public enum Operator {
    IS_MORE_THEN((subject, argument) -> subject.getOperations().isMoreThen(argument)),
    IS_MORE_EQUAL_THEN((subject, argument) -> subject.getOperations().isMoreEqualThen(argument)),
    IS_LESS_THEN((subject, argument) -> subject.getOperations().isLessThen(argument));

    private final BiPredicate<RangeItem, Integer> predicate;

    Operator(BiPredicate<RangeItem, Integer> predicate) {
        this.predicate = predicate;
    }

    public boolean execute(RangeItem subject, Integer argument){
        return predicate.test(subject, argument);
    }
}
