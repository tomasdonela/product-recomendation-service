package com.interview.seb.entity.product;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.interview.seb.entity.product.criteria.ProductCriterion;

import java.util.List;

public class Product {
    private final String name;
    private final List<ProductCriterion> criteria;

    @JsonCreator()
    public Product(@JsonProperty("name") String name, @JsonProperty("criteria") List<ProductCriterion> criteria) {
        this.name = name;
        this.criteria = criteria;
    }

    public String getName() {
        return name;
    }

    public List<ProductCriterion> getCriteria() {
        return criteria;
    }
}