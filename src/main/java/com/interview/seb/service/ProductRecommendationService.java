package com.interview.seb.service;

import com.interview.seb.entity.product.Product;
import com.interview.seb.entity.question.AnswerOption;
import com.interview.seb.entity.question.Question;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductRecommendationService {

    private final FileRepository<Product> productRepository;
    private final FileRepository<Question> questionRepository;

    public ProductRecommendationService(
            FileRepository<Product> productRepository, FileRepository<Question> questionRepository) {
        this.productRepository = productRepository;
        this.questionRepository = questionRepository;
    }

    public List<Product> calculateRecommendation(Map<String, String> customerAnswers){
        Map<String, Optional<AnswerOption>> answers = questionRepository.findAll()
                .stream()
                .collect(Collectors.toMap(
                        Question::getSubject,
                        question -> Optional
                                .ofNullable(customerAnswers.get(question.getSubject()))
                                .map(question::getAnswerOption)
                        ));

        return productRepository.findAll()
                .stream()
                .filter(product -> product.getCriteria()
                        .stream()
                        .allMatch(criteria -> criteria.isMatching(answers)))
                .collect(Collectors.toList());
    }

    public List<Question> getQuestions(){
        return questionRepository.findAll();
    }
}
