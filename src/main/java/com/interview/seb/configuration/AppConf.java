package com.interview.seb.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.interview.seb.product.Product;
import com.interview.seb.question.Question;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConf {

    @Bean
    public ObjectMapper objectMapper(){
        return new ObjectMapper();
    }
}
