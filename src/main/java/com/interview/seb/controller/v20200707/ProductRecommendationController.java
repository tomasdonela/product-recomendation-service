package com.interview.seb.controller.v20200707;

import com.interview.seb.controller.v20200707.entity.ExternalCustomerAnswers;
import com.interview.seb.controller.v20200707.entity.ExternalProductCollection;
import com.interview.seb.controller.v20200707.entity.ExternalQuestion;
import com.interview.seb.service.ProductRecommendationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("v20200707/product-recommendation")
public class ProductRecommendationController {

    private final ProductRecommendationService productRecommendationService;

    public ProductRecommendationController(
            ProductRecommendationService productRecommendationService
    ) {
        this.productRecommendationService = productRecommendationService;
    }

    @PostMapping
    public ExternalProductCollection getProducts(@RequestBody ExternalCustomerAnswers customerAnswers){
        return ExternalProductCollection.valueOf(
                productRecommendationService.calculateRecommendation(customerAnswers.toInternal()));
    }

    @GetMapping("/questions")
    public List<ExternalQuestion> getQuestions(){
        return productRecommendationService.getQuestions()
                .stream()
                .map(ExternalQuestion::valueOf)
                .collect(Collectors.toList());
    }
}
