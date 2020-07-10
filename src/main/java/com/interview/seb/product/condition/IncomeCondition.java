package com.interview.seb.product.condition;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.interview.seb.entity.CustomerDescriptor;

public class IncomeCondition implements Condition {

    private Operator operator;
    private Integer argument;

    @JsonCreator()
    private IncomeCondition(@JsonProperty("operator") Operator operator, @JsonProperty("argument") Integer argument) {
        this.operator = operator;
        this.argument = argument;
    }

    @Override
    public boolean isMatching(CustomerDescriptor customerDescriptor) {
        return operator.execute(customerDescriptor.getIncomeRange(), argument);
    }
}
