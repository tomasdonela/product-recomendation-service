package com.interview.seb.product.condition;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.interview.seb.entity.CustomerDescriptor;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME , property = "subject")
@JsonSubTypes({
        @JsonSubTypes.Type(value = AgeCondition.class, name = "AGE"),
        @JsonSubTypes.Type(value = IncomeCondition.class, name = "INCOME"),
        @JsonSubTypes.Type(value = StudentCondition.class, name = "STUDENT")
})
public interface Condition {
    boolean isMatching(CustomerDescriptor customerDescriptor);
}
