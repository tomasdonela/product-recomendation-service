package com.interview.seb.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.interview.seb.product.Product;
import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;

@Repository
public class ProductRepository {

    private final String productFileName;
    private final ObjectMapper objectMapper;

    public ProductRepository(@Value("${app.datasource.product.file-name}") String productFileName, ObjectMapper objectMapper) {
        this.productFileName = productFileName;
        this.objectMapper = objectMapper;
    }

    public List<Product> findAll(){
        try {
            return objectMapper.readValue(new ClassPathResource(productFileName).getFile(), new TypeReference<List<Product>>(){});
        } catch (IOException e) {
            throw new IllegalStateException(String.format("Error while reading products: %s", e.getMessage()));
        }
    }
}
