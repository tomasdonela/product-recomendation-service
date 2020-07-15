package com.interview.seb.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class FileRepository<T> {

    private final ObjectMapper objectMapper;
    private final Resource resource;
    private final CollectionType type;
    public FileRepository(Resource resource, ObjectMapper objectMapper, Class<T> clazz) {
        this.objectMapper = objectMapper;
        this.resource = resource;
        this.type = TypeFactory.defaultInstance().constructCollectionType(ArrayList.class, clazz);
    }

    public List<T> findAll(){
        try (InputStream stream = resource.getInputStream()){
            return objectMapper.readValue(stream, type);
        } catch (IOException e) {
            throw new IllegalStateException(
                    String.format("Error while reading from resource %s: %s", resource.getFilename(), e.getMessage()));
        }
    }
}
