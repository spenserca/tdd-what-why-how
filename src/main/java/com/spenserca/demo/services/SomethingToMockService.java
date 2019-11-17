package com.spenserca.demo.services;

import com.spenserca.demo.models.Animal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SomethingToMockService {
    private static final Logger logger = LoggerFactory.getLogger(SomethingToMockService.class);

    public void logAnimal(Animal animal) {
        logger.info(animal.toString());
    }
}
