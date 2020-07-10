package com.interview.seb.product.condition;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.interview.seb.entity.CustomerDescriptor;

public class AgeCondition implements Condition {

    private final Operator operator;
    private final Integer argument;

    @JsonCreator()
    private AgeCondition(@JsonProperty("operator") Operator operator, @JsonProperty("argument") Integer argument) {
        this.operator = operator;
        this.argument = argument;
    }

    @Override
    public boolean isMatching(CustomerDescriptor customerDescriptor) {
        return operator.execute(customerDescriptor.getAgeRange(), argument);
    }
}
