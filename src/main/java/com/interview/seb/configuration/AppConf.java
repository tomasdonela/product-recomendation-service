package com.interview.seb.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.interview.seb.entity.product.Product;
import com.interview.seb.entity.question.Question;
import com.interview.seb.service.FileRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

@Configuration
public class AppConf {

    @Bean
    public ObjectMapper objectMapper(){
        return new ObjectMapper()
                .registerModule(new JavaTimeModule())
                .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
    }

    @Bean("productRepository")
    public FileRepository<Product> productRepository(@Value("${app.datasource.product.resource}") Resource resource){
        return new FileRepository<>(resource, objectMapper(), Product.class);
    }

    @Bean("questionRepository")
    public FileRepository<Question> questionRepository(@Value("${app.datasource.question.resource}") Resource resource){
        return new FileRepository<>(resource, objectMapper(), Question.class);
    }
}
