package com.spenserca.demo.services;

import com.spenserca.demo.models.Animal;

import java.util.List;

public class LooperService {
    private final SomethingToMockService somethingToMockService;

    public LooperService(SomethingToMockService somethingToMockService) {
        this.somethingToMockService = somethingToMockService;
    }

    public List<Animal> loopAnimals(List<Animal> animals) {
        animals.forEach((animal -> {
            somethingToMockService.logAnimal(animal);
        }));

        return animals;
    }
}
