package com.interview.seb.service;

import com.interview.seb.product.Product;

import java.util.*;
import java.util.stream.Collectors;

import com.interview.seb.question.AnswerOption;
import com.interview.seb.question.Question;
import org.springframework.stereotype.Service;

@Service
public class ProductRecommendationService {

    private final ProductRepository productRepository;
    private final QuestionRepository questionRepository;

    public ProductRecommendationService(ProductRepository productRepository, QuestionRepository questionRepository) {
        this.productRepository = productRepository;
        this.questionRepository = questionRepository;
    }

    public List<Product> calculateRecommendation(Map<String, String> customerAnswers){
        Map<String, Optional<AnswerOption>> answers = questionRepository.findAll()
                .stream()
                .collect(Collectors.toMap(
                        Question::getSubject,
                        question -> question.getAnswerOption(customerAnswers.get(question.getSubject()))))                ;

        return productRepository.findAll()
                .parallelStream()
                .filter(product -> product.getConditions()
                        .parallelStream()
                        .allMatch(condition -> condition.isMatching(answers)))
                .collect(Collectors.toList());
    }

    public List<Question> getQuestions(){
        return questionRepository.findAll();
    }
}
