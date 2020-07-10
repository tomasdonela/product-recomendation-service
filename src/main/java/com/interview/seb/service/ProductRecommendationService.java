package com.interview.seb.service;

import com.interview.seb.entity.CustomerDescriptor;
import com.interview.seb.product.Product;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class ProductRecommendationService {

    private final ProductRepository productRepository;

    public ProductRecommendationService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> calculateRecommendation(CustomerDescriptor customerDescriptor){
        return productRepository.findAll()
                .parallelStream()
                .filter(product -> product.getConditions()
                        .parallelStream()
                        .allMatch(condition -> condition.isMatching(customerDescriptor)))
                .collect(Collectors.toList());
    }
}
