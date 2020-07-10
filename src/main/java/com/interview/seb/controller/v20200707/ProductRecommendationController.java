package com.interview.seb.controller.v20200707;

import com.interview.seb.controller.v20200707.entity.ExternalCustomerDescriptor;
import com.interview.seb.controller.v20200707.entity.ExternalProductCollection;
import com.interview.seb.service.ProductRecommendationService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v20200707/product-recomendation")
public class ProductRecommendationController {

    private final ProductRecommendationService productRecommendationService;

    public ProductRecommendationController(
            ProductRecommendationService productRecommendationService
    ) {
        this.productRecommendationService = productRecommendationService;
    }

    @PostMapping
    public ExternalProductCollection getProducts(ExternalCustomerDescriptor customerDescriptor){
        return ExternalProductCollection.valueOf(
                productRecommendationService.calculateRecommendation(customerDescriptor.toInternal()));
    }
}
