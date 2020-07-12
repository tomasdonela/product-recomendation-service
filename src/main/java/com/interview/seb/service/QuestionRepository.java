package com.interview.seb.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.interview.seb.question.Question;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.List;

@Repository
public class QuestionRepository {

    private final String fileName;
    private final ObjectMapper objectMapper;

    public QuestionRepository(@Value("${app.datasource.question.file-name}") String fileName, ObjectMapper objectMapper) {
        this.fileName = fileName;
        this.objectMapper = objectMapper;
    }

    public List<Question> findAll(){
        try {
            return objectMapper.readValue(new ClassPathResource(fileName).getFile(), new TypeReference<List<Question>>(){});
        } catch (IOException e) {
            throw new IllegalStateException(String.format("Error while reading from file %s: %s", fileName, e.getMessage()));
        }
    }
}
