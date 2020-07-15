package com.interview.seb.service;

import com.interview.seb.entity.product.Product;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class ProductRecommendationServiceTest extends ServiceTestBase{

    private final ProductRecommendationService productRecommendationService =
            new ProductRecommendationService(productRepository, questionRepository);

    @Test
    void shouldReturnCurrentAccount(){
        Map<String, String> customerAnswers = Map.of(
                Subject.INCOME.name(), Income.INCOME_1_12000.getText(),
                Subject.AGE.name(), Age.AGE_18_64.getText());

        List<Product> products = productRecommendationService.calculateRecommendation(customerAnswers);
        assertThat(products, hasItem(hasProperty("name", is("Current Account"))));
    }

    @Test
    void shouldReturnCurrentAccountPlus(){
        Map<String, String> customerAnswers = Map.of(
                Subject.INCOME.name(), Income.INCOME_40001_PLUS.getText(),
                Subject.AGE.name(), Age.AGE_18_64.getText());

        List<Product> products = productRecommendationService.calculateRecommendation(customerAnswers);
        assertThat(products, hasItem(hasProperty("name", is("Current Account Plus"))));
    }

    @Test
    void shouldReturnJuniorSaverAccount(){
        Map<String, String> customerAnswers = Map.of(
                Subject.AGE.name(), Age.AGE_0_17.getText());

        List<Product> products = productRecommendationService.calculateRecommendation(customerAnswers);
        assertThat(products, hasItem(hasProperty("name", is("Junior Saver Account"))));
    }

    @Test
    void shouldReturnJuniorStudentAccount(){
        Map<String, String> customerAnswers = Map.of(
                Subject.STUDENT.name(), YesNo.YES.getText(),
                Subject.AGE.name(), Age.AGE_18_64.getText());

        List<Product> products = productRecommendationService.calculateRecommendation(customerAnswers);
        assertThat(products, hasItem(hasProperty("name", is("Student Account"))));
    }

    @Test
    void shouldReturnSeniorAccount(){
        Map<String, String> customerAnswers = Map.of(
                Subject.AGE.name(), Age.AGE_65_PLUS.getText());

        List<Product> products = productRecommendationService.calculateRecommendation(customerAnswers);
        assertThat(products, hasItem(hasProperty("name", is("Senior Account"))));
    }

    @Test
    void shouldReturnDebitCard(){
        Map<String, String> customerAnswers = Map.of(
                Subject.INCOME.name(), Income.INCOME_0.getText(),
                Subject.AGE.name(), Age.AGE_18_64.getText());

        List<Product> products = productRecommendationService.calculateRecommendation(customerAnswers);
        assertThat(products, hasItem(hasProperty("name", is("Debit Card"))));
    }

    @Test
    void shouldReturnCreditCard(){
        Map<String, String> customerAnswers = Map.of(
                Subject.INCOME.name(), Income.INCOME_12001_40000.getText(),
                Subject.AGE.name(), Age.AGE_18_64.getText());

        List<Product> products = productRecommendationService.calculateRecommendation(customerAnswers);
        assertThat(products, hasItem(hasProperty("name", is("Credit Card"))));
    }

    @Test
    void shouldReturnGoldCreditCard(){
        Map<String, String> customerAnswers = Map.of(
                Subject.INCOME.name(), Income.INCOME_40001_PLUS.getText(),
                Subject.AGE.name(), Age.AGE_18_64.getText());

        List<Product> products = productRecommendationService.calculateRecommendation(customerAnswers);
        assertThat(products, hasItem(hasProperty("name", is("Gold Credit Card"))));
    }
}