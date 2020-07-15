package com.interview.seb.controller.v20200707.entity;

import com.interview.seb.entity.product.Product;
import io.swagger.annotations.ApiModel;

@ApiModel("v20200707.ExternalProduct")
public class ExternalProduct {
    private String name;

    public ExternalProduct(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static ExternalProduct valueOf(Product product){
        return new ExternalProduct(product.getName());
    }
}
