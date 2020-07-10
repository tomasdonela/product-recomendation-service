package com.interview.seb.product.condition;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.interview.seb.entity.CustomerDescriptor;

public class StudentCondition implements Condition {

    private Boolean argument;

    @JsonCreator()
    private StudentCondition(@JsonProperty("argument") Boolean argument) {
        this.argument = argument;
    }

    @Override
    public boolean isMatching(CustomerDescriptor customerDescriptor) {
        return customerDescriptor.isStudent() == argument;
    }
}
