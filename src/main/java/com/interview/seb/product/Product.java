package com.interview.seb.product;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.interview.seb.product.condition.Condition;
import java.util.List;

public class Product {
    private String name;
    private List<Condition> conditions;

    @JsonCreator()
    public Product(@JsonProperty("name") String name, @JsonProperty("conditions") List<Condition> conditions) {
        this.name = name;
        this.conditions = conditions;
    }

    public String getName() {
        return name;
    }

    public List<Condition> getConditions() {
        return conditions;
    }
}
