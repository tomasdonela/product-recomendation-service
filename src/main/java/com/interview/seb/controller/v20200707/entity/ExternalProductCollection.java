package com.interview.seb.controller.v20200707.entity;

import com.interview.seb.product.Product;
import io.swagger.annotations.ApiModel;
import java.util.List;
import java.util.stream.Collectors;

@ApiModel("v20200707.ExternalProductCollection")
public class ExternalProductCollection {
    private List<ExternalProduct> products;

    private ExternalProductCollection(List<ExternalProduct> products) {
        this.products = products;
    }

    public List<ExternalProduct> getProducts() {
        return products;
    }

    public static ExternalProductCollection valueOf(List<Product> products){
        return new ExternalProductCollection(
                products
                        .stream()
                        .map(ExternalProduct::valueOf)
                        .collect(Collectors.toList())
        );
    }
}
