package com.interview.seb.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.interview.seb.entity.product.Product;
import com.interview.seb.entity.question.Question;
import org.springframework.core.io.ClassPathResource;

public class ServiceTestBase {
    private final ObjectMapper objectMapper = new ObjectMapper();
    FileRepository<Product> productRepository = new FileRepository<>(
            new ClassPathResource("products.json"),
            objectMapper,
            Product.class);
    FileRepository<Question> questionRepository = new FileRepository<>(
            new ClassPathResource("questions.json"),
            objectMapper,
            Question.class);

    enum Subject{
        AGE, INCOME, STUDENT
    }

    enum Age {
        AGE_0_17("0-17"), AGE_18_64("18-64"), AGE_65_PLUS("65+");
        private final String text;
        Age(String text) {
            this.text = text;
        }

        public String getText() {
            return text;
        }
    }

    enum Income {
        INCOME_0("0"), INCOME_1_12000("1-12000"),
        INCOME_12001_40000("12001-40000"), INCOME_40001_PLUS("40001+");
        private final String text;
        Income(String text) {
            this.text = text;
        }

        public String getText() {
            return text;
        }
    }

    enum YesNo {
        YES("Yes");
        private final String text;
        YesNo(String text) {
            this.text = text;
        }

        public String getText() {
            return text;
        }
    }
}
